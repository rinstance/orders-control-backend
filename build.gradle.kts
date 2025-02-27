
import org.gradle.jvm.tasks.Jar

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "ru.applications"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
//    mainClass.set("ru.applications.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.h2)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}

tasks.create("stage") {
    dependsOn("installDist")
}

//val fatJar = task("fatJar", type = Jar::class) {
//    baseName = "${project.name}-fat"
//    // manifest Main-Class attribute is optional.
//    // (Used only to provide default main class for executable jar)
//    manifest {
//        attributes["Main-Class"] = "example.HelloWorldKt" // fully qualified class name of default main class
//    }
//    from(configurations.runtime.map({ if (it.isDirectory) it else zipTree(it) }))
//    with(tasks["jar"] as CopySpec)
//}

//tasks {
//    "build" {
//        dependsOn(fatJar)
//    }
//}
