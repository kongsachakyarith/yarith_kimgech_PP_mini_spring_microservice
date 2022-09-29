FROM eclipse-temurin:17.0.3_7-jre-alpine
ADD ./eureka-server/build/libs/eureka-server-1.0.0.jar root.jar
ENTRYPOINT ["java"]
CMD ["-jar", "root.jar"]