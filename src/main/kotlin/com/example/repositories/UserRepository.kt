package com.example.repositories

import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.models.user_models.User
import com.example.models.user_models.UserResponseParam

interface UserRepository {
    suspend fun registerUser(params: RegisterUserParams): UserResponseParam
    suspend fun loginUser(params: LoginUserParams): UserResponseParam
}