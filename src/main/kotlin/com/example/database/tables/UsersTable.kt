package com.example.database.tables

import org.jetbrains.exposed.sql.Table

object UsersTable: Table("users") {

    val id = integer("id").autoIncrement()
    val userId = varchar("userId", 200)
    val name = varchar("name", 2000)
    val lastname = varchar("lastname", 2000)
    val email = varchar("email", 2000)
    val password = text("password")
    val role = varchar("role", 200)
    override val primaryKey = PrimaryKey(id)

}