plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // eureka client
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")
}