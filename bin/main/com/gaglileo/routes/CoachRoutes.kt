package com.gaglileo.routes

import com.gaglileo.models.Coach
import com.gaglileo.models.coachesStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.coachRouting() {
    route("/coach") {
        get {
            if(coachesStorage.isNotEmpty()) {
                call.respond(coachesStorage)
            }
            else {
                call.respondText("No coaches found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"]?: return@get call.respondText("Missing id param", status = HttpStatusCode.BadRequest)
            val coach = coachesStorage.find { it.id == id }
            coach?.let {
                call.respond(it)
            }?: call.respondText("No coaches found", status = HttpStatusCode.NotFound)
        }
        post {
            val coach = call.receive<Coach>()
            coachesStorage.add(coach)
            call.respondText("Coach created", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"]?: return@delete call.respondText("Missing id param", status = HttpStatusCode.BadRequest)
            if(coachesStorage.removeIf { it.id == id }) {
                call.respondText("Coach removed", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("No coaches found", status = HttpStatusCode.NotFound)
            }
        }
    }
}