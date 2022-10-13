package com.projeto.tech.share.accountapi.application.route

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class PingRouter {

    @Bean
    fun routes() = coRouter {
        GET("/ping") {
            ServerResponse.ok().bodyValueAndAwait("pong")
        }
    }
}