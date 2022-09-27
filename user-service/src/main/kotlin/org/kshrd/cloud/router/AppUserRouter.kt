package com.kshrd.demo.userservice.router

import com.kshrd.demo.userservice.handler.AppUserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@Configuration
class AppUserRouter(val appUserHandler: AppUserHandler) {
    @Bean
    fun appUserRouter(): RouterFunction<ServerResponse> =
        router{
            "/api/v1".nest{
//                GET("/users/{id}", appUserHandler::getAllUserById)
            }
        }

}