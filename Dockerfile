FROM amazoncorretto:11
MAINTAINER pmb
COPY target/pmb-0.0.1-SNAPSHOT.jar pmb-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pmb-0.0.1-SNAPSHOT"]
