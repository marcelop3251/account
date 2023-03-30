package com.projeto.tech.share.accountapi.application.security.token

import com.projeto.tech.share.accountapi.resources.repository.service.UserService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component

@Component
class JwtService {
    private val expiration: Long = 1000 * 15 * 60

    @Value("\${jwt.secret}")
    private lateinit var jwtSecret: String

    fun generateToken(authentication: Authentication, roles: MutableList<GrantedAuthority>): String {
        val loggedUser = authentication.principal as UserService
        return Jwts.builder()
            .setSubject(loggedUser.userEntity.id)
            .setIssuer("Api account-api")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration))
            .claim("role", roles)
            .signWith(SignatureAlgorithm.HS512, jwtSecret.toByteArray())
            .compact()
    }

    fun isValid(jwt: String) = try {
        Jwts.parser().setSigningKey(jwtSecret.toByteArray()).parseClaimsJwt(jwt)
        true
    } catch (ex: RuntimeException) {
        //TODO logar erros de validação de jwt
        false
    }

    fun decodeAccessToken(token: String): Claims {
        val tokenClear = token.replace("Bearer ", "")
        return if (isValid(tokenClear)) {
            Jwts.parser().setSigningKey(jwtSecret.toByteArray()).parseClaimsJwt(tokenClear).body
        } else {
            throw IllegalArgumentException("Token is invalid")
        }
    }

}