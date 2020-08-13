package pl.edu.agh.sukiennik.thesis.config.services

import akka.japi.Pair
import akka.stream.Materializer
import akka.stream.javadsl.AsPublisher
import akka.stream.javadsl.Sink
import akka.stream.javadsl.Source
import hu.akarnokd.rxjava3.math.MathFlowable
import io.reactivex.rxjava3.core.Flowable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import pl.edu.agh.sukiennik.thesis.config.Message
import reactor.core.publisher.Mono
import reactor.math.MathFlux
import java.math.BigInteger


@Service
class AverageHandler(private val passThroughHandler: PassThroughHandler, private val materializer: Materializer) {

    fun handleReactorAverage(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message).map { t -> t.id.hashCode() }
            val avgFlux = MathFlux.averageBigInteger(ackMessage)

            ServerResponse.ok().body(avgFlux, BigInteger::class.java)
        }
    }

    fun handleReactorAverageMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message).map { t -> t.id.hashCode() }
            val avgFlux = MathFlux.averageBigInteger(ackMessage)

            ServerResponse.status(HttpStatus.OK).body(avgFlux, BigInteger::class.java)
        }
    }

    fun handleRxJavaAverage(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message)

            val rxJavaFlow = Flowable.fromPublisher(ackMessage).map { t -> t.id.hashCode() }
            val avgFlowable = MathFlowable.averageDouble(rxJavaFlow)

            ServerResponse.ok().body(avgFlowable, Double::class.java)
        }
    }

    fun handleRxJavaAverageMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughHandler.passThroughMultiple(message)

            val rxJavaFlow = Flowable.fromPublisher(ackMessages).map { t -> t.id.hashCode() }
            val avgFlowable = MathFlowable.averageDouble(rxJavaFlow)

            ServerResponse.status(HttpStatus.OK).body(avgFlowable, Double::class.java)
        }
    }

    fun handleAkkaAverage(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessage = passThroughHandler.passThrough(message)

            val akkaSource = Source.fromPublisher(ackMessage).map { t -> t.id.hashCode() }.zipWithIndex()
                    .reduce { arg1, arg2 -> Pair(arg1.first() + arg2.first(), arg2.second()) }
                    .map { param -> param.first() / param.second() }.take(1)
            val publisher = akkaSource.runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), materializer)

            ServerResponse.ok().body(publisher, Long::class.java)
        }
    }

    fun handleAkkaAverageMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughHandler.passThroughMultiple(message)

            val akkaSource = Source.fromPublisher(ackMessages).map { t -> t.id.hashCode() }.zipWithIndex()
                    .reduce { arg1, arg2 -> Pair(arg1.first() + arg2.first(), arg2.second()) }
                    .map { param -> param.first() / param.second() }.take(1)
            val publisher = akkaSource.runWith(Sink.asPublisher(AsPublisher.WITHOUT_FANOUT), materializer)

            ServerResponse.status(HttpStatus.OK).body(publisher, Long::class.java)
        }
    }
}
