FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package
WORKDIR /app/target
EXPOSE 8001
CMD ["java", "-jar", "your-application.jar"]
 
