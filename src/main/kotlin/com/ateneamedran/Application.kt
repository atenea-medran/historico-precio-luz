package com.ateneamedran

import com.ateneamedran.dao.DatabaseFactory
import com.ateneamedran.plugins.configureRouting
import com.ateneamedran.plugins.configureTemplating
import com.ateneamedran.utilities.Utilities
import io.ktor.server.application.*


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureTemplating()
    configureRouting()
    DatabaseFactory.init(environment.config)
    Utilities.scheduleUpdateEveryDay(Utilities.updateDay())
}
