package com.ateneamedran.plugins

import com.ateneamedran.dao.dao
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("/files")
        }
        route("/") {
            get {
                call.respond(FreeMarkerContent("table.ftl", model = mapOf("days" to dao.showTable())))
            }
        }
    }
}

