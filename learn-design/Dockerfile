FROM openjdk:8
COPY ./target/classes/com/DockerfileTest.class /tmp
WORKDIR /tmp
RUN ls -l
ENTRYPOINT ["java", "DockerfileTest"]