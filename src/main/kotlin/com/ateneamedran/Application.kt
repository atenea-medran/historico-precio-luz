package com.ateneamedran

import com.ateneamedran.dao.DatabaseFactory
import com.ateneamedran.plugins.configureRouting
import com.ateneamedran.plugins.configureTemplating
import com.ateneamedran.utilities.addNewDay
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
//    io.ktor.server.netty.EngineMain.main(args)
    addNewDay("https://apidatos.ree.es/en/datos/mercados/precios-mercados-tiempo-real?start_date=2023-03-03T00:00&end_date=2023-03-04T00:00&time_trunc=hour")

//@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
//fun Application.module() {
//    configureTemplating()
//    configureRouting()
//    DatabaseFactory.init(environment.config)
//
//}
