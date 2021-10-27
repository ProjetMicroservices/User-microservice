FROM java:8
EXPOSE 8091
ADD /target/User_Microservice-0.0.1-SNAPSHOT.jar User_Microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar" , "User_Microservice-0.0.1-SNAPSHOT.jar" ]