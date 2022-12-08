package com.projeto.tech.share.accountapi.application.handler

import com.projeto.tech.share.accountapi.domain.SignUpUseCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class RegisterHandler(
    val signUpUseCase: SignUpUseCase
) {
    suspend fun signUp(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(signUpUseCase.execute())
    }
}