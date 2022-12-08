package com.projeto.tech.share.accountapi.application.route

import com.projeto.tech.share.accountapi.application.handler.RegisterHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RegisterClientRouter(
    val handler: RegisterHandler
) {

    @Bean
    fun routeRegister() = coRouter {
        POST("/sign-up", handler::signUp)
    }
}