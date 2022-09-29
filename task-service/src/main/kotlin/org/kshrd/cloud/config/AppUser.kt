package org.kshrd.cloud.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class AppUser{

    @Bean("AppUser")
     fun appUser(): WebClient =
        WebClient
            .builder()
            .baseUrl("http://localhost:8081")
            .build()
}
