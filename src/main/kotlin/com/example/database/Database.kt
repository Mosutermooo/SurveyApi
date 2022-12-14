package com.example.database

import com.example.database.tables.UsersTable
import com.example.utils.Constants
import com.example.utils.Constants.dbUrl
import com.example.utils.Constants.driver
import com.example.utils.Constants.password
import com.example.utils.Constants.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Database {
    fun connect(){
        Database.connect(
            url = dbUrl,
            driver = driver,
            user = user,
            password = password
        )
        transaction {
            SchemaUtils.create(UsersTable)
        }
    }

    suspend fun <T> dbQuery(block: () -> T): T = withContext(Dispatchers.IO){
        transaction {
            block()
        }
    }

}