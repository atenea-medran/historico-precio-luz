package com.ateneamedran.dao

import com.ateneamedran.models.centims
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val hikariDatasource = HikariDataSource().apply {
            driverClassName = config.property("storage.driverClassName").getString()
            jdbcUrl = config.property("storage.jdbcURL").getString()
            username = config.property("storage.username").getString()
            password = config.property("storage.password").getString()
        }
        val database = Database.connect(hikariDatasource)
        transaction(database) {
            SchemaUtils.create(centims)
        }
    }
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}