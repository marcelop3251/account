package com.projeto.tech.share.accountapi.application.security.token

import org.springframework.stereotype.Component

@Component
class JwtService(
    val secrety: String
) {

    fun generateToken(): String {
        // como recuperar o user e criar o token
    }

    fun isValid(jwt: String) {
        //

    }

    fun decodeAccessToken() {

    }

}