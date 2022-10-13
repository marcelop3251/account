package com.projeto.tech.share.accountapi.application.route

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class LoginRouter {

    fun routes() = coRouter{
        POST("/login") {
            ServerResponse.ok().bodyValueAndAwait("Logado")
        }
    }
}