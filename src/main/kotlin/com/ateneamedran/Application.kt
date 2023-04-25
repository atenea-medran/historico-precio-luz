package com.ateneamedran

import com.ateneamedran.dao.DatabaseFactory
import com.ateneamedran.plugins.configureRouting
import com.ateneamedran.plugins.configureTemplating
import io.ktor.server.application.*
import java.time.LocalTime


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureTemplating()
    configureRouting()
    DatabaseFactory.init(environment.config)
    Methods.scheduleUpdateEveryDay(Methods.updateDay(), LocalTime.of(19, 15, 0, 0))
}
