# Build Stage
FROM gradle:7.6.3-jdk17 AS build
WORKDIR /app
# Copy the Gradle configuration files first and download dependencies
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle gradle
COPY gradlew .
RUN chmod +x ./gradlew
RUN ./gradlew --no-daemon dependencies
# Now copy the rest of the source code and build the jar
COPY src src
RUN ./gradlew --no-daemon bootJar

# Extract Stage
FROM openjdk:17-alpine AS extract
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Final Stage
FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
WORKDIR /app
# Copy the extracted layers
COPY --from=extract /app/dependencies/ ./
COPY --from=extract /app/spring-boot-loader/ ./
COPY --from=extract /app/snapshot-dependencies/ ./
COPY --from=extract /app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
