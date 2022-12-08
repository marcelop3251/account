package com.projeto.tech.share.accountapi.domain

import com.projeto.tech.share.accountapi.resources.repository.spring.UserRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class SignUpUseCase(
    val userRepository: UserRepository
) {

    suspend fun execute(): Flow<Any> {
        return userRepository.findAllByName()
    }
}