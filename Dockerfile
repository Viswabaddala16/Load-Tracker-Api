FROM openjdk:22
EXPOSE 8080
ADD target/postgresql-0.0.1-SNAPSHOT.jar postgresql-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/postgresql-0.0.1-SNAPSHOT.jar"]