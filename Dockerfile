FROM eclipse-temurin:17
COPY target/*.jar apigateway.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","apigateway.jar"]
