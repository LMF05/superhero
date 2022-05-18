FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} superhero.jar
ENTRYPOINT ["java","-jar","/superhero.jar"]
EXPOSE 8080:8080
