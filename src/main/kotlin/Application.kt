package ru.applications

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
//    EngineMain.main(args)
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureDatabases()
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureSecurity()
    configureRouting()
}
