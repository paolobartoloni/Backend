FROM amazoncorretto:20-alpine-jdk
MAINTAINER pmb
COPY target/pmb-0.0.1-SNAPSHOT.jar pmb.jar
ENTRYPOINT ["java","-jar","/pmb.jar"]
