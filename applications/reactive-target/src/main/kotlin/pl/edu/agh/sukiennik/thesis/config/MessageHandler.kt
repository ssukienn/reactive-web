package pl.edu.agh.sukiennik.thesis.config

import io.micrometer.core.instrument.Metrics
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToFlux
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class MessageHandler {

    private val counter = Metrics.counter("handler.calls", "uri", "/messages")
    private val multipleCounter = Metrics.counter("handler.calls", "uri", "/multiple-messages")

    fun handleMessage(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono<Message>().flatMap { m ->
            counter.increment()
            Mono
                    .fromCallable { MessageAck(id = m.id, received = m.payload, ack = "ack") }
                    .delayElement(Duration.ofMillis(m.delay))
                    .flatMap { messageAck ->
                        ServerResponse
                                .status(HttpStatus.OK)
                                .body(fromObject(messageAck))
                    }
        }
    }

    fun handleMultipleMessage(req: ServerRequest): Mono<ServerResponse> {
         val ackMessages = req.bodyToFlux<Message>().flatMap { m ->
             multipleCounter.increment()
             Mono
                    .fromCallable { MessageAck(id = m.id, received = m.payload, ack = "ack") }
                    .repeat(m.size)
                    .delaySubscription(Duration.ofMillis(m.delay))
        }
        return ServerResponse.status(HttpStatus.OK).body(ackMessages, MessageAck::class.java)
    }
}
