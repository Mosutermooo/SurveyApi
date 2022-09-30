package com.example.secutiry

import io.ktor.server.auth.*

data class UserIdPrincipalForUser(val userId: String): Principal
