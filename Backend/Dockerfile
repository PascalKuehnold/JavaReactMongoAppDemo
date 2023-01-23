FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

EXPOSE 8080

COPY Backend/.mvn/ .mvn
COPY Backend/pom.xml ./
COPY Backend/mvnw ./

# # clean up the file
# RUN sed -i 's/\r$//' mvnw
# # run with the SH path
# RUN /bin/sh mvnw dependency:resolve

COPY Backend/src ./src

CMD ["./mvnw", "spring-boot:run"]


# FROM eclipse-temurin:17-jdk-jammy
# EXPOSE 8080
# ADD target/demo-app.jar demo-app.jar
# ENTRYPOINT [ "java", "-jar", "/demo-app.jar" ]


