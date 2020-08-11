package pl.edu.agh.sukiennik.thesis.config

import akka.actor.ActorSystem
import akka.stream.Materializer
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient
import pl.edu.agh.sukiennik.thesis.config.services.PassThroughHandler


@SpringBootApplication
class ReactiveWebApplication {
    
    @Value("\${loadtarget.host}")
    lateinit var targetHost: String;

    @Bean
    fun webClient() : WebClient {
        return WebClient.builder()
                .baseUrl(targetHost)
                .build()
    }
    
    @Bean
    fun passThroughHandler(webClient: WebClient): PassThroughHandler {
        return PassThroughHandler(webClient)
    }

    @Bean
    fun actorSystem(): ActorSystem {
        return ActorSystem.create("system")
    }

    @Bean
    fun materializer(actorSystem: ActorSystem): Materializer {
        return Materializer.createMaterializer(actorSystem)
    }

    @Bean
    fun commonTags(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry ->
            registry.config()
                    .commonTags("application", "reactive-solution-web")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ReactiveWebApplication>(*args)
}
