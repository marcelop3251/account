package com.projeto.tech.share.accountapi.domain.repository

import com.projeto.tech.share.accountapi.domain.entity.User

interface UserRepository {
    suspend fun create(user: User): User
}