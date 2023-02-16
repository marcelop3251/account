package com.projeto.tech.share.accountapi.resources.repository.service

import com.projeto.tech.share.accountapi.resources.repository.spring.UserRepositorySpring
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserDetailsService(
    private val userRepository: UserRepositorySpring
) : ReactiveUserDetailsService {

    override fun findByUsername(username: String): Mono<UserDetails> = mono {
        UserService(userRepository.findByName(username))
    }
}