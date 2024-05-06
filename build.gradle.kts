plugins {
    kotlin("jvm") version "1.9.23"
}

group = "es.leanmind"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation(platform("io.kotest:kotest-bom:5.8.1"))
    testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}