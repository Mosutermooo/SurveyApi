package com.example.models.user_models

import kotlinx.serialization.Serializable

@Serializable
data class LoginUserParams(
    val email: String,
    val password: String
            )
