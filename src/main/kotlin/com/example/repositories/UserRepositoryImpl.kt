package com.example.repositories

import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.models.user_models.User
import com.example.models.user_models.UserResponseParam
import com.example.services.UserService

class UserRepositoryImpl(private val service: UserService): UserRepository {
    override suspend fun registerUser(params: RegisterUserParams): UserResponseParam {
        return if(isEmailExiting(params.email)){
            UserResponseParam("There is a account with that email", false)
        }else{
            service.registerUser(params)
        }

    }

    override suspend fun loginUser(params: LoginUserParams): UserResponseParam {
        return service.loginUser(params)
    }

    private suspend fun isEmailExiting(email: String): Boolean{
        return service.findUserByEmail(email)
    }

    private suspend fun String.emailExist(result: (Boolean) -> Boolean){
        result.invoke(service.findUserByEmail(this))
    }

}