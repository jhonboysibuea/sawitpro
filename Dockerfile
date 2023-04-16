FROM openjdk:8-jdk-alpine
MAINTAINER jhonboysibuea
WORKDIR /assignment
RUN rm -frv /assignment/assignment.jar
VOLUME /tmp
EXPOSE 8080
ADD target/assignment-0.0.1-SNAPSHOT.jar /assignment/assignment.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/assignment/assignment.jar"]