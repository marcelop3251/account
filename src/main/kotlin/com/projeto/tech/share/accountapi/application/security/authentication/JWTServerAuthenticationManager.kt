package com.projeto.tech.share.accountapi.application.security.authentication

import com.projeto.tech.share.accountapi.application.security.token.JwtService
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.server.WebFilterExchange
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class JWTServerAuthenticationManager(
    val jwtService: JwtService
) : ServerAuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(webFilterExchange: WebFilterExchange, authentication: Authentication?): Mono<Void> = mono {
        val principal = authentication?.principal ?: throw IllegalArgumentException("No authorized")

        when (principal) {
            is UserDetails -> {
                val roles = principal.authorities
                val accessToken = jwtService.generateToken(authentication, roles.toMutableList())
                webFilterExchange.exchange.response.headers.set("Authorization", accessToken)
            }
        }
        return@mono null
    }
}