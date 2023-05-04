FROM amazoncorretto:19
MAINTAINER pmb
COPY target/pmb-0.0.1-SNAPSHOT.jar pmb-app.jar
ENTRYPOINT ["java","-jar","/pmb-app.jar"]
