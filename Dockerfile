FROM adoptopenjdk/openjdk11

RUN mkdir -p /software

ADD target/warbug-0.0.1-SNAPSHOT.jar /software/warbug-0.0.1-SNAPSHOT.jar

CMD java -Dserver.port=$PORT $JAVA_OPTS -jar /software/warbug-0.0.1-SNAPSHOT.jar