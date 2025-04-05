plugins {
    id("org.jetbrains.kotlin.jvm") version "2.1.10"
    id("gg.jte.gradle") version("3.2.1-SNAPSHOT")
}

repositories {
    mavenCentral()
    mavenLocal()
}

group = "gg.jte.testgroup"

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation("gg.jte:jte-runtime:3.2.1-SNAPSHOT")
    implementation("gg.jte:jte-kotlin:3.2.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.10")

    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    jteGenerate("gg.jte:jte-models:3.2.1-SNAPSHOT")
}

jte {
    generate()
    binaryStaticContent = true
    jteExtension("gg.jte.models.generator.ModelExtension") {
        property("language", "Kotlin")
        property("implementationAnnotation", "@test.Dummy")
        property("includePattern", ".*")
        property("excludePattern", ".*Excluded.*")
    }
}
