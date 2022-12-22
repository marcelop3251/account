package com.projeto.tech.share.accountapi.resources.repository.entity


import com.projeto.tech.share.accountapi.domain.entity.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.crypto.password.PasswordEncoder

private const val SECRET = "<secret>"

@Document(collection = "user")
data class UserEntity(
    @Id
    var id: String? = null,
    val name: String,
    val email: String,
    val password: String
)  {

    fun toDomain(): User = User(
        id = id,
        name = name,
        email,
        password = SECRET
    )

    constructor(user: User, passwordEncoder: PasswordEncoder) : this (
        name = user.name,
        email = user.email,
        password = passwordEncoder.encode(user.password)
    )
}