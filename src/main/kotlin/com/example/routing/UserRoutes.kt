package com.example.routing

import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.repositories.UserRepository
import com.example.services.UserService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRoutes(service: UserRepository){
    routing {
        route("/auth"){
            post("/register") {
                val params = call.receive<RegisterUserParams>()
                val result =  service.registerUser(params)
                call.respond(result)
            }
            post("/login"){
                val params = call.receive<LoginUserParams>()
                val result = service.loginUser(params)
                call.respond(result)
            }
        }
    }
}