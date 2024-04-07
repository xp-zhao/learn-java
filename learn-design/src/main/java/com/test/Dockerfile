FROM openjdk:8
COPY . /app/com/test
WORKDIR /app
RUN javac com/test/DockerfileTest.java
CMD ["java", "com.test.DockerfileTest"]
#CMD ["java", "-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005", "com.test.DockerfileTest"]