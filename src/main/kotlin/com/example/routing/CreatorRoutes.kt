package com.example.routing

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.creatorRoutes(){
    routing {
        authenticate {
            route("/creator"){
                post("/become-creator"){

                }
                post ("/create-survey"){

                }


            }
        }
    }
}