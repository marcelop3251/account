package com.projeto.tech.share.accountapi.domain.entity

data class User(
    val id: String? = null,
    val name: String,
    val email: String,
    val password: String
)