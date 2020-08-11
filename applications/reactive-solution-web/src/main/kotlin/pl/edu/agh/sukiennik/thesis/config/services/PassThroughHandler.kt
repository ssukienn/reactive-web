package pl.edu.agh.sukiennik.thesis.config.services

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import pl.edu.agh.sukiennik.thesis.config.Message
import pl.edu.agh.sukiennik.thesis.config.MessageAck

class PassThroughHandler(private val webClient: WebClient) {

    fun handle(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            passThrough(message)
                    .flatMap { messageAck ->
                        ServerResponse.ok().body(fromObject(messageAck))
                    }
        }
    }

    fun handleMultiple(serverRequest: ServerRequest): Mono<ServerResponse> {
        val messageMono = serverRequest.bodyToMono<Message>()

        return messageMono.flatMap { message ->
            val ackMessages = passThroughMultiple(message)

            //do something with returned items

            ServerResponse.status(HttpStatus.OK).body(ackMessages, MessageAck::class.java)
        }
    }

    fun passThrough(message: Message): Mono<MessageAck> {
        return webClient.post()
                .uri("/messages")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(fromObject(message))
                .exchange()
                .flatMap { response: ClientResponse ->
                    response.bodyToMono<MessageAck>()
                }
    }

    fun passThroughMultiple(message: Message): Flux<MessageAck> {
        return webClient.post()
                .uri("/messages/multiple")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(fromObject(message))
                .retrieve()
                .bodyToFlux(MessageAck::class.java)
    }
}
