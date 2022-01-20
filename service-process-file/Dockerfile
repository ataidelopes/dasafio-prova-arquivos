FROM openjdk:11
WORKDIR "/app"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar

RUN mkdir -p /app/data/in \
    && mkdir -p /app/data/out \
    && mkdir -p /app/data/done

ENTRYPOINT ["java","-jar","/app/app.jar"]
