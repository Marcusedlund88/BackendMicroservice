FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/security-micro.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app.jar"]