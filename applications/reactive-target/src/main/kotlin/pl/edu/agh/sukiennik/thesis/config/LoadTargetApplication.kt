package pl.edu.agh.sukiennik.thesis.config

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LoadTargetApplication {

    @Bean
    fun commonTags(): MeterRegistryCustomizer<MeterRegistry> {
        return MeterRegistryCustomizer { registry ->
            registry.config()
                    .commonTags("application", "sample-load-target")
        }
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(LoadTargetApplication::class.java, *args)
}
