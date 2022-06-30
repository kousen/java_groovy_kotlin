// Without these suppressions, version catalog usage here and in other build
// files is marked red by IntelliJ:
// https://youtrack.jetbrains.com/issue/KTIJ-19369.
@Suppress(
    "DSL_SCOPE_VIOLATION",
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED"
)
plugins {
    java
    groovy
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.versions)
    alias(libs.plugins.version.catalog.update)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.groovy)
    implementation(libs.groovy.json)
    implementation(libs.groovy.swing)
    implementation(libs.gson)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.script.runtime)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.converter)
    implementation(libs.retrofit.core)


    testImplementation(libs.spock)
    testImplementation(libs.bundles.junit)
}

tasks.test {
    useJUnitPlatform {
        maxParallelForks = Runtime.getRuntime().availableProcessors() / 2 + 1
    }
}