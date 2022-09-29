package com.example.services

import com.example.database.Database.dbQuery
import com.example.database.tables.UsersTable
import com.example.models.user_models.LoginUserParams
import com.example.models.user_models.RegisterUserParams
import com.example.models.user_models.User
import com.example.models.user_models.UserResponseParam
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.mindrot.jbcrypt.BCrypt

class UserServiceImpl : UserService {

    override suspend fun registerUser(params: RegisterUserParams): UserResponseParam {
        val result = dbQuery{
            UsersTable.insert {
                it[userId] = generateUserId()
                it[name] = params.name
                it[lastname] = params.lastname
                it[email] = params.email
                it[password] = hashPassword(params.password)
            }
        }
        if(result.insertedCount == 1){
            return UserResponseParam(
                "Successfully created user",
                true
            )
        }
        return UserResponseParam(
            "Something went wrong",
            false
        )

    }

    override suspend fun findUserByEmail(email: String): User? {
        return dbQuery {
            UsersTable.select{ UsersTable.email.eq(email) }
                .map {
                    rowToUser(it)
                }.singleOrNull()
        }
    }

    override suspend fun loginUser(params: LoginUserParams): UserResponseParam {
        val user = findUserByEmail(params.email)
            ?: return UserResponseParam("User does not exist", false)

        user.token = "asdasd"

        return UserResponseParam(
            "User ${user.name}",
            true,
            user
        )


    }

    private fun rowToUser(row: ResultRow?): User? {
        return if(row == null) null
        else User(
            id = row[UsersTable.id],
            userId = row[UsersTable.userId],
            name = row[UsersTable.name],
            lastname = row[UsersTable.lastname],
            email = row[UsersTable.email],
        )
    }
    private fun generateUserId(): String {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return List(20) { alphabet.random() }.joinToString("")
    }

    private fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }


}