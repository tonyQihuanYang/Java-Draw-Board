FROM maven:3.8.7-eclipse-temurin-19 AS builder
VOLUME /tmp
WORKDIR /

# Copy and Install Dependency
COPY ./pom.xml .
RUN mvn dependency:go-offline -B

# Copy Source Code
COPY ./src ./src
# Build
RUN mvn package
RUN ls
RUN mv ./target/*.jar /*.jar

#Copy from previous build
FROM eclipse-temurin:19
COPY --from=builder ./*.jar drawBoard.jar
EXPOSE 8080
# Run Jar
ENTRYPOINT ["java", "-jar", "drawBoard.jar"]
