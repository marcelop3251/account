package com.projeto.tech.share.accountapi.resources.repository.entity


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
    @Id
    var id: Int? = null,
    val name: String
)