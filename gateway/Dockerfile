FROM maven:3.8.5-openjdk-17 as build
WORKDIR /
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./target/*.jar ./app.jar
ENTRYPOINT java -jar app.jar --spring.profiles.active=prod
EXPOSE 8088
