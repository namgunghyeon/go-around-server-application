description = "mysql-domain"

plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa") version "1.6.10"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("mysql:mysql-connector-java")

    runtimeOnly("com.h2database:h2:1.4.200")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}