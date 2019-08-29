ARG PASSWORD
FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean -Djasypt.encryptor.password=${PASSWORD} package -P sql -Dmaven.test.skip=true
FROM java:8
WORKDIR /opt/website
ENV ENV_PASSWORD=${PASSWORD}
COPY --from=maven-build /build/target/spring-batch-example-1-0.0.1-SNAPSHOT.jar opt/app.jar
ENTRYPOINT ENTRYPOINT java -jar -Djasypt.encryptor.password=${ENV_PASSWORD} opt/app.jar
