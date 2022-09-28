plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}


dependencies {

    implementation ("org.springframework.cloud:spring-cloud-starter-gateway:3.1.1")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")
}
