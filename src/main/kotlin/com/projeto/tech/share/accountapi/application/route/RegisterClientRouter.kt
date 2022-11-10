package com.projeto.tech.share.accountapi.application.route

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RegisterClientRouter {

    fun routeRegister() = coRouter {
        POST("/sign-up") {

        }
    }
}