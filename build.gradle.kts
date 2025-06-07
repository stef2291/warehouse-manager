plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("manualRun") {
    group = "application"
    description = "Runs Main class"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.Main")
    standardInput = System.`in`
}

tasks.register<JavaExec>("loadStubs") {
    group = "testing"
    description = "Create dummy data for testing purposes"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.Main")
    args("createStubs")
    standardInput = System.`in`
}