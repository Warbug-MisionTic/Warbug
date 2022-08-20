FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/warbug-0.0.1-SNAPSHOT.jar warbug-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","warbug-0.0.1-SNAPSHOT.jar"]