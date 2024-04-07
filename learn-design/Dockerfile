FROM openjdk:8
COPY ./target/learn-design-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
RUN ls -l
ENTRYPOINT ["java", "-jar", "learn-design-1.0-SNAPSHOT-jar-with-dependencies.jar"]