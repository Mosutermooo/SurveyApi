package com.example.models.user_models

import kotlinx.serialization.Serializable


@Serializable
data class RegisterUserParams (
    val name: String,
    val lastname: String,
    val email: String,
    val password: String
        )