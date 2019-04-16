FROM maven:3.6.0-jdk-8-alpine 
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests


CMD ["java","-jar","/home/app/target/management-0.0.1-SNAPSHOT.jar"]