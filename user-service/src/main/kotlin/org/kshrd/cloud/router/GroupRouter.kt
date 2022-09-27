package org.kshrd.cloud.router

import org.kshrd.cloud.config.GroupOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class GroupRouter {

    @GroupOperations
    @Bean
    fun groupRouter(): RouterFunction<ServerResponse> = router {
        "/api/v1".nest {

        }
    }
}