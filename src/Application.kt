package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/respond-200") {
            call.respond(HttpStatusCode.OK)
        }

        get("/status-200") {
            call.response.status(HttpStatusCode.OK) // Mistake
        }

        get("/respond-404") {
            call.respond(HttpStatusCode.NotFound)
        }

        get("/status-404") {
            call.response.status(HttpStatusCode.NotFound) // Mistake
        }
    }
}

