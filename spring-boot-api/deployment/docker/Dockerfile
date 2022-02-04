FROM maven:3.6.0-jdk-11 AS build
     
LABEL maintainer="Yiyi Kang <yiyikangrachel@gmail.com>"

COPY . /app/spring-boot-api
WORKDIR /app/spring-boot-api
RUN mvn clean package -Dmaven.test.skip

FROM gcr.io/distroless/java11-debian11
COPY --from=build /app/spring-boot-api/target/spring-boot-api-*.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-Dserver.address=centos7-master", "-Dspring.profiles.active=stage", "-XX:MaxMetaspaceSize=256M", "-XX:+HeapDumpOnOutOfMemoryError", "-jar",  "./lib/spring-boot-api-1.0.0.jar" ]
