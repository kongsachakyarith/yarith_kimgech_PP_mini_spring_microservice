FROM eclipse-temurin:17.0.3_7-jre-alpine
ADD ./config-server/build/libs/config-server-1.0.0.jar root.jar
ENTRYPOINT ["java"]
CMD ["-jar", "root.jar"]