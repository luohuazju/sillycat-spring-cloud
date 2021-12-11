FROM maven:3.6.0-jdk-11 AS build
     
LABEL maintainer="Yiyi Kang <yiyikangrachel@gmail.com>"

COPY . /app/spring-boot-restful
WORKDIR /app/spring-boot-restful
RUN mvn clean package -Dmaven.test.skip
WORKDIR /app/spring-boot-restful/target
RUN tar -xzf spring-boot-restful-1.0.0-bundle.tar.gz

FROM gcr.io/distroless/java11-debian11
COPY --from=build /app/spring-boot-restful/target/spring-boot-restful-1.0.0 /app/
WORKDIR /app
CMD	[ "java", "-Djava.net.preferIPv4Stack=true", "-XX:MaxMetaspaceSize=256M", "-XX:+HeapDumpOnOutOfMemoryError", "-Dspring.config.location=file:./conf/application.yaml", "-Dlogging.config=file:./conf/log4j2.xml", "-jar",  "./lib/spring-boot-restful-1.0.0.jar" ]
