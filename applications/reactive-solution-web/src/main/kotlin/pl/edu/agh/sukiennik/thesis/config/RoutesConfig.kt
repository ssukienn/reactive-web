package pl.edu.agh.sukiennik.thesis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router
import pl.edu.agh.sukiennik.thesis.config.services.AverageHandler
import pl.edu.agh.sukiennik.thesis.config.services.FilterHandler
import pl.edu.agh.sukiennik.thesis.config.services.MapHandler
import pl.edu.agh.sukiennik.thesis.config.services.PassThroughHandler

@Configuration
class RoutesConfig {

    @Bean
    fun apis(passThroughHandler: PassThroughHandler) = router {
        POST("/passthrough/messages", passThroughHandler::handle)
        POST("/passthrough/messages/multiple", passThroughHandler::handleMultiple)
    }

    @Bean
    fun mapApis(mapHandler: MapHandler) = router {
        POST("/reactor/map", mapHandler::handleReactorMap)
        POST("/reactor/map/multiple", mapHandler::handleReactorMapMultiple)
        POST("/rxjava/map", mapHandler::handleRxJavaMap)
        POST("/rxjava/map/multiple", mapHandler::handleRxJavaMapMultiple)
        POST("/akka/map", mapHandler::handleAkkaMap)
        POST("/akka/map/multiple", mapHandler::handleAkkaMapMultiple)
    }

    @Bean
    fun filterApis(filterHandler: FilterHandler) = router {
        POST("/reactor/filter", filterHandler::handleReactorFilter)
        POST("/reactor/filter/multiple", filterHandler::handleReactorFilterMultiple)
        POST("/rxjava/filter", filterHandler::handleRxJavaFilter)
        POST("/rxjava/filter/multiple", filterHandler::handleRxJavaFilterMultiple)
        POST("/akka/filter", filterHandler::handleAkkaFilter)
        POST("/akka/filter/multiple", filterHandler::handleAkkaFilterMultiple)
    }

    @Bean
    fun averageApis(averageHandler: AverageHandler) = router {
        POST("/reactor/average", averageHandler::handleReactorAverage)
        POST("/reactor/average/multiple", averageHandler::handleReactorAverageMultiple)
        POST("/rxjava/average", averageHandler::handleRxJavaAverage)
        POST("/rxjava/average/multiple", averageHandler::handleRxJavaAverageMultiple)
        POST("/akka/average", averageHandler::handleAkkaAverage)
        POST("/akka/average/multiple", averageHandler::handleAkkaAverageMultiple)
    }
    
}
