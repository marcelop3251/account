package com.projeto.tech.share.accountapi.application.handler

import com.projeto.tech.share.accountapi.application.dto.UserRequest
import com.projeto.tech.share.accountapi.domain.usecase.SignUpUseCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait


@Component
class RegisterHandler(
    val signUpUseCase: SignUpUseCase
) {
    suspend fun signUp(request: ServerRequest): ServerResponse {
        val userRequest = request.awaitBody<UserRequest>()
        // TODO devemos retornar diretamente o domain?
        return ServerResponse.ok().bodyValueAndAwait(signUpUseCase.execute(userRequest.toDomain()))
    }
}