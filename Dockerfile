# Multi-stage Dockerfile for Spring Boot Application (Production Profile)

# ============================================
# Stage 1: Build Stage
# ============================================
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy POM and source files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# ============================================
# Stage 2: Runtime Stage (Production Optimized)
# ============================================
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Install curl for health checks
RUN apk add --no-cache curl

# Copy JAR from builder stage
COPY --from=builder /build/target/*.jar app.jar

# Create non-root user for security
RUN addgroup -g 1000 appuser && \
    adduser -D -u 1000 -G appuser appuser && \
    chown -R appuser:appuser /app

USER appuser

# Expose ports
# Port 9092: Main application port (Production profile)
# Port 8081: Actuator/Management port
EXPOSE 9092 8081

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
    CMD curl -f http://localhost:9092/ || exit 1

# Environment variables
ENV SPRING_PROFILES_ACTIVE=prod

# Run the application with optimized JVM settings
# JVM Settings:
# -XX:+UseSerialGC: Serial Garbage Collector (suitable for small containers)
# -Xss512k: Stack size limit (512KB)
# -Xms150m: Initial heap size (150MB)
# -Xmx300m: Maximum heap size (300MB)
ENTRYPOINT ["java", "-XX:+UseSerialGC", "-Xss512k", "-Xms150m", "-Xmx300m", "-jar", "app.jar"]
