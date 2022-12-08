package com.projeto.tech.share.accountapi.resources.repository.spring

import com.projeto.tech.share.accountapi.resources.repository.entity.User
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CoroutineCrudRepository<User, Int> {

    suspend fun findAllByName(): Flow<User>
}