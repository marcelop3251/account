package com.projeto.tech.share.accountapi.application.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SpringConfiguration {

    @Bean
    fun springFilter(
        http: ServerHttpSecurity
    ) : SecurityWebFilterChain {
        http.csrf().disable()
            .authorizeExchange()
            .pathMatchers(HttpMethod.GET, "/ping").permitAll()
            .pathMatchers(HttpMethod.POST, "/sign-up").permitAll()
            .pathMatchers(HttpMethod.POST, "/login").permitAll()
            .anyExchange().authenticated()

        return http.build()
    }
}