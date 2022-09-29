package org.kshrd.cloud

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableDiscoveryClient
@EnableR2dbcRepositories
@OpenAPIDefinition(
    servers = [Server(url = "/")] ,
    info = Info(title="User API",version = "1.0", description = "Documentation User API 1.0," ))
class UserServiceApplication

fun main(args: Array<String>){
    runApplication<UserServiceApplication>(*args)
}