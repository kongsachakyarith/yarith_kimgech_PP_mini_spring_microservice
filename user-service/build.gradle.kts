plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
//    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springdoc:springdoc-openapi-webflux-core:1.6.9")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.9")

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation ("org.springdoc:springdoc-openapi-ui:1.4.3")
//    implementation ("org.springdoc:springdoc-openapi-security:1.4.3")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // eureka client
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")

}
