package com.projeto.tech.share.accountapi.domain.usecase

import com.projeto.tech.share.accountapi.domain.repository.UserRepository
import com.projeto.tech.share.accountapi.domain.entity.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpUseCase(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {

    suspend fun execute(user: User): User {
        // TODO DESAFIO VALIDAR SE O USER EXISTE NA BASE
        return userRepository.create(user)
    }
}