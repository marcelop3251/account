package com.projeto.tech.share.accountapi.resources.repository.service

import com.projeto.tech.share.accountapi.resources.repository.entity.UserEntity
import java.util.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserService(
    val userEntity: UserEntity
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = Collections.emptyList()

    override fun getPassword(): String  = userEntity.password

    override fun getUsername(): String = userEntity.name

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean  = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}