package com.projeto.tech.share.accountapi.application.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

class SignUpHandler {

    suspend fun signUp(request: ServerRequest): ServerResponse {

        return ServerResponse.ok().bodyValueAndAwait("ok")
    }
}