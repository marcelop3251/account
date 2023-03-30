package com.projeto.tech.share.accountapi.application.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers

@Configuration
@EnableWebFluxSecurity
class SpringConfiguration {

    @Bean
    fun springFilter(
        http: ServerHttpSecurity,
        authenticationWebFilter: AuthenticationWebFilter,
    ) : SecurityWebFilterChain {
        http.csrf().disable()
            .authorizeExchange()
            .pathMatchers(HttpMethod.GET, "/ping").permitAll()
            .pathMatchers(HttpMethod.GET, "/login").permitAll()
            .pathMatchers(HttpMethod.POST, "/sign-up").permitAll()
            .anyExchange()
            .authenticated()
            .and()
            .addFilterBefore(authenticationWebFilter, SecurityWebFiltersOrder.AUTHORIZATION)
            .httpBasic()
            //.addFilterBefore(tokenJwtAuthorization, SecurityWebFiltersOrder.AUTHENTICATION)


        return http.build()
    }

    @Bean
    fun authenticationManager(userDetailsService: ReactiveUserDetailsService, passwordEncoder: PasswordEncoder) : ReactiveAuthenticationManager {
        val manager = UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService)
        manager.setPasswordEncoder(passwordEncoder)
        return manager
    }

    @Bean
    fun authenticationWebFilter(reactiveAuthenticationManager: ReactiveAuthenticationManager): AuthenticationWebFilter {
        val authenticationWebFilter = AuthenticationWebFilter(reactiveAuthenticationManager)
        //TODO como implementar o JWT
        authenticationWebFilter.setRequiresAuthenticationMatcher {
            ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/login").matches(it)
        }
        return authenticationWebFilter
    }
}

