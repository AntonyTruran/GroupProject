FROM maven:latest as maven-build
WORKDIR /build
COPY . /build
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8084
COPY --from=maven-build /build/target/BuildingAPI-0.0.1-SNAPSHOT.jar buildingapi.jar
ENTRYPOINT ["java", "-jar", "buildingapi.jar"]