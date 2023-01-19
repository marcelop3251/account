package com.projeto.tech.share.accountapi.resources.repository.spring

import com.projeto.tech.share.accountapi.resources.repository.entity.UserEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepositorySpring : CoroutineCrudRepository<UserEntity, Int> {

    suspend fun findByName(userName: Any): UserEntity

}