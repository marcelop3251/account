package com.projeto.tech.share.accountapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class AccountApiApplication

fun main(args: Array<String>) {
	runApplication<AccountApiApplication>(*args)
}
