package com.projeto.tech.share.accountapi.resources.repository.spring

import com.projeto.tech.share.accountapi.domain.repository.UserRepository
import com.projeto.tech.share.accountapi.domain.entity.User
import com.projeto.tech.share.accountapi.resources.repository.entity.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserRepositoryImpl(
    private val userRepositorySpring: UserRepositorySpring,
    private val passwordEncoder: PasswordEncoder,
) : UserRepository {

    override suspend fun create(user: User): User {
        return userRepositorySpring.save(UserEntity(user, passwordEncoder)).toDomain()
    }
}