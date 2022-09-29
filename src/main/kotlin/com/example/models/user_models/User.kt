package com.example.models.user_models

import com.example.database.tables.UsersTable
import com.example.database.tables.UsersTable.autoIncrement
import kotlinx.serialization.Serializable

@Serializable
class User (
    val id : Int,
    val userId: String,
    val name: String,
    val lastname: String,
    val email: String,
    val token: String? = null
        )