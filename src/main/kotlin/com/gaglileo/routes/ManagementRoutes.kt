package com.gaglileo.routes

import com.gaglileo.models.leagueStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.managementRouting() {
    route("/management") {
        route("/player"){
            post("buy/{teamId}/{playerId}") {
                val teamId = call.parameters["teamId"]
                val playerId = call.parameters["playerId"]
                val team = leagueStorage.teams.find { it.id == teamId }?: return@post call.respondText("No teams found", status = HttpStatusCode.NotFound)
                val player = leagueStorage.players.find { it.id == playerId }?: return@post call.respondText("No player found", status = HttpStatusCode.NotFound)

                team.players.add(player)
                call.respondText("Player bought", status = HttpStatusCode.OK)
            }
            post("sell/{teamId}/{playerId}") {

            }
        }
        route("/coach") {
            post("buy/{teamId}/{coachId}") {
                val teamId = call.parameters["teamId"]
                val coachId = call.parameters["coachId"]
                val team = leagueStorage.teams.find { it.id == teamId }?: return@post call.respondText("No teams found", status = HttpStatusCode.NotFound)
                val coach = leagueStorage.coaches.find { it.id == coachId }?: return@post call.respondText("No coach found", status = HttpStatusCode.NotFound)

                team.coach = coach
                call.respondText("Coach bought", status = HttpStatusCode.OK)
            }
            post("sell/{teamId}/{coachId}") {

            }
        }
    }
}