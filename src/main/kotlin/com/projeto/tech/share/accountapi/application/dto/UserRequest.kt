package com.projeto.tech.share.accountapi.application.dto

import com.projeto.tech.share.accountapi.domain.entity.User

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
) {
    fun toDomain(): User = User(
        name = name,
        email = email,
        password = password
    )
}