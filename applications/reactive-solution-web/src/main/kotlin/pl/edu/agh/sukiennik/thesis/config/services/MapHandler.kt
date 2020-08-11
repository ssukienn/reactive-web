package pl.edu.agh.sukiennik.thesis.config.services

import akka.NotUsed
import akka.stream.javadsl.Sink
import akka.stream.javadsl.Source
import io.reactivex.rxjava3.core.Flowable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import pl.edu.agh.sukiennik.thesis.config.Message
import pl.edu.agh.sukiennik.thesis.config.MessageAck
import akka.stream.Materializer
import akka.stream.javadsl.AsPublisher


@Service
class MapHandler(private val passThroughHandler: PassThroughHandler, private val materializer: Materializer) {


    private fun mapper(msg: MessageAck): MessageAck {
        return MessageAck(id = msg.id.toUpperCase(), received = msg.received.toUpperCase(), ack = "ack".toUpperCase())
    }

    fun handleReactorMap(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message).map { msg -> mapper(msg) }

            ServerResponse.ok().body(ackMessage, MessageAck::class.java)
        }
    }

    fun handleReactorMapMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughHandler.passThroughMultiple(message).map { msg -> mapper(msg) }

            ServerResponse.status(HttpStatus.OK).body(ackMessages, MessageAck::class.java)
        }
    }

    fun handleRxJavaMap(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message)

            val rxJavaFlow: Flowable<MessageAck> = Flowable.fromPublisher(ackMessage).map { msg -> mapper(msg) }

            ServerResponse.ok().body(rxJavaFlow, MessageAck::class.java)
        }
    }

    fun handleRxJavaMapMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughHandler.passThroughMultiple(message)

            val rxJavaFlow: Flowable<MessageAck> = Flowable.fromPublisher(ackMessages).map { msg -> mapper(msg) }

            ServerResponse.status(HttpStatus.OK).body(rxJavaFlow, MessageAck::class.java)
        }
    }

    fun handleAkkaMap(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message)

            val akkaSource: Source<MessageAck, NotUsed> = Source.fromPublisher(ackMessage).map { param -> mapper(param)  }
            val publisher = akkaSource.runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), materializer)

            ServerResponse.ok().body(publisher, MessageAck::class.java)
        }
    }

    fun handleAkkaMapMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughHandler.passThroughMultiple(message)

            val akkaSource: Source<MessageAck, NotUsed> = Source.fromPublisher(ackMessages).map { param -> mapper(param)  }
            val publisher = akkaSource.runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), materializer)

            ServerResponse.status(HttpStatus.OK).body(publisher, MessageAck::class.java)
        }
    }
}
