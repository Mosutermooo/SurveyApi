package com.example.repositories

import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.models.user_models.User
import com.example.models.user_models.UserResponseParam
import com.example.services.UserService

class UserRepositoryImpl(private val service: UserService): UserRepository {
    override suspend fun registerUser(params: RegisterUserParams): UserResponseParam {
        return if(service.findUserByEmail(params.email) != null){
            UserResponseParam("There is not a account with that email", false)
        }else{
            service.registerUser(params)
        }

    }

    override suspend fun loginUser(params: LoginUserParams): UserResponseParam {
        return service.loginUser(params)
    }



}