FROM java:8
VOLUME /tmp
ADD docker-hello-world-1.0-SNAPSHOT.jar /opt/docker-hello-world-1.0-RELEASE.jar
RUN bash -c 'touch /opt/docker-hello-world-1.0-RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/docker-hello-world-1.0-RELEASE.jar"]