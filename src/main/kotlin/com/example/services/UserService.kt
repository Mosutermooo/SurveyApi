package com.example.services


import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.models.user_models.User
import com.example.models.user_models.UserResponseParam

interface UserService {
    suspend fun registerUser(params: RegisterUserParams): UserResponseParam
    suspend fun findUserByEmail(email: String): Boolean
    suspend fun loginUser(params: LoginUserParams): UserResponseParam

}