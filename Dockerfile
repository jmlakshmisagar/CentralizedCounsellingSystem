FROM eclipse-temurin:21-jre

LABEL maintainer="Lakshmisagar JM"

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]