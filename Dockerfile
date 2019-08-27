
FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package -P sql -Dmaven.test.skip=true
FROM java:8
WORKDIR /opt/website
COPY --from=maven-build /build/target/spring-batch-example-1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]