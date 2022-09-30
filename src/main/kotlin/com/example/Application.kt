package com.example

import com.example.database.Database
import com.example.repositories.UserRepository
import com.example.repositories.UserRepositoryImpl
import com.example.routing.userRoutes
import com.example.secutiry.configureSecurity
import com.example.services.UserService
import com.example.services.UserServiceImpl
import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main(){
    embeddedServer(Netty, port = 8080){

        Database.connect()

        install(ContentNegotiation){
            json()
        }
        configureSecurity()
        val userService : UserService = UserServiceImpl()
        val userRepository : UserRepository = UserRepositoryImpl(userService)
        userRoutes(userRepository)

    }.start(true)
}