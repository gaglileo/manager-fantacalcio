package com.gaglileo.plugins

import com.gaglileo.routes.coachRouting
import com.gaglileo.routes.managementRouting
import com.gaglileo.routes.playerRouting
import com.gaglileo.routes.teamRouting
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        playerRouting()
        coachRouting()
        teamRouting()
        managementRouting()
    }
}
