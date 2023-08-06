package com.gaglileo.routes

import com.gaglileo.models.Player
import com.gaglileo.models.playersInLeague
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.playerRouting() {
    route("/players") {
        post {
            val player = call.receive<Player>()
            playersInLeague.add(player)
            call.respondText("Player added", status = HttpStatusCode.Created)
        }
    }
}