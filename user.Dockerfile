FROM eclipse-temurin:17.0.3_7-jre-alpine
ADD ./user-service/build/libs/user-service-1.0.0.jar root.jar
ENTRYPOINT ["java"]
CMD ["-jar", "root.jar"]