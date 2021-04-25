FROM gradle:jdk11-openj9 as builder

COPY . /app
WORKDIR /app
RUN gradle clean shadowJar

FROM  openjdk:11.0.10-jre-slim as runner

COPY --from=builder /app/build/libs/*all.jar /app/app.jar
WORKDIR /app
ENV PORT=9999
EXPOSE $PORT 9999
CMD java -Dmicronaut.environments=$ENVIROMENTS -Dmicronaut.server.port=$PORT -jar app.jar