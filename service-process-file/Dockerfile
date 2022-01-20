FROM maven:3.8.4-jdk-11 AS MAVEN_BUILD

WORKDIR /build
COPY . /build

RUN mvn clean package

FROM openjdk:11-jre-stretch
COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
