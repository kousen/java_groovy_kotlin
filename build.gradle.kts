import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    groovy
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

val groovyVersion by extra("3.0.9")
val kotlinVersion by extra("1.6.10")
val junitVersion by extra("5.8.2")
val spockVersion by extra("2.0-groovy-3.0")

dependencies {
    implementation("org.codehaus.groovy:groovy:$groovyVersion")
    implementation("org.codehaus.groovy:groovy-json:$groovyVersion")
    implementation("org.codehaus.groovy:groovy-swing:$groovyVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    testImplementation("org.spockframework:spock-core:$spockVersion")
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.vintage:junit-vintage-engine")
}

tasks.test {
    useJUnitPlatform {
        maxParallelForks = Runtime.getRuntime().availableProcessors() / 2 + 1
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}