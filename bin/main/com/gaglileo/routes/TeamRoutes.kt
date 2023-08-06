package com.gaglileo.routes

import com.gaglileo.models.Team
import com.gaglileo.models.leagueStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.teamRouting() {
    route("/team") {
        get {
            if(leagueStorage.teams.isNotEmpty()) {
                call.respond(leagueStorage.teams)
            } else {
                call.respondText("No teams found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"]?: return@get call.respondText("Missing id param", status = HttpStatusCode.BadRequest)
            val team = leagueStorage.teams.find { it.id == id }
            team?.let {
                call.respond(it)
            }?: call.respondText("No teams found", status = HttpStatusCode.NotFound)
        }
        get("{name?}") {
            val name = call.parameters["name"]?: return@get call.respondText("Missing name param", status = HttpStatusCode.BadRequest)
            val team = leagueStorage.teams.find { it.name == name }
            team?.let {
                call.respond(it)
            }?: call.respondText("No teams found", status = HttpStatusCode.NotFound)
        }
        post {
            val team = call.receive<Team>()
            leagueStorage.teams.add(team)
            call.respondText("Team created", status = HttpStatusCode.Created)
        }

    }
}