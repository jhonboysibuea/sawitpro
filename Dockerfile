ROM openjdk:8-jdk-alpine
MAINTAINER jhonboysibuea
VOLUME /tmp
EXPOSE 8080
ADD target/assignment-0.0.1-SNAPSHOT.jar assignment.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/assignment.jar"]