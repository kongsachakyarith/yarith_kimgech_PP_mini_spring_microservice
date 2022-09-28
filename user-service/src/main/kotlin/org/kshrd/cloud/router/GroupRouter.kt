package org.kshrd.cloud.router

import org.kshrd.cloud.config.GroupOperations
import org.kshrd.cloud.handler.GroupHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class GroupRouter (val groupHandler: GroupHandler){

    @Bean
    @GroupOperations
    fun groupsRouter(): RouterFunction<ServerResponse> =
        router{
        "/api/v1".nest{
//            GET("/test", appUserHandler::testing)
            GET("/groups",groupHandler::getAllGroups)
            GET("/groups/{id}",groupHandler::findById)
            POST("/groups",groupHandler::createGroup)
        }
    }
}