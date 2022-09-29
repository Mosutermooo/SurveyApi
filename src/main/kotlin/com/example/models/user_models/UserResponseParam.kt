package com.example.models.user_models

import kotlinx.serialization.Serializable


@Serializable
data class UserResponseParam(
    val message: String,
    val success: Boolean,
    val user: User? = null
        )