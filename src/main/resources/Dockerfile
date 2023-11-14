FROM openjdk:11-jre-slim
WORKDIR /app
COPY libs/spiEngine-0.0.1-SNAPSHOT.jar .
COPY libs/* ./lib/
ENV CLASSPATH /app:/app/lib/*
NTRYPOINT ["java", "-jar", "spiEngine-0.0.1-SNAPSHOT.jar"]