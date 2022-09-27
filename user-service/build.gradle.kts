plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}
extra["springCloudVersion"] = "Hoxton.SR9"
val springCloudVersion = "Hoxton.SR9"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation ("org.springframework.cloud:spring-cloud-starter-config")
    implementation ("org.springframework.boot:spring-boot-starter-web:2.7.3")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    // eureka client
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.4")
}
dependencyManagement {
    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}