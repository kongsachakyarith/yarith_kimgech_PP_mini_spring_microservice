package org.kshrd.cloud.router

import org.kshrd.cloud.config.AppUserOperations
import org.kshrd.cloud.handler.AppUserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class AppUserRouter(val appUserHandler: AppUserHandler){

    @Bean
    @AppUserOperations
    fun userRouter(): RouterFunction<ServerResponse> =
        router{
            "/api/v1".nest{
                GET("/users/{id}",appUserHandler::getAllUserById)
                POST("/users",appUserHandler::createAppUser)
                DELETE("/users/{id}",appUserHandler::deleteUserById)
                PUT("/users/profile/{id}",appUserHandler::updateUserProfileById)
//                GET("/test", appUserHandler::testing)
        }
        }

}