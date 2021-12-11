FROM maven:3.6.0-jdk-11 AS build
     
LABEL maintainer="Yiyi Kang <yiyikangrachel@gmail.com>"

COPY . /app/spring-boot-restful
WORKDIR /app/spring-boot-restful
RUN mvn clean package -Dmaven.test.skip
WORKDIR /app/spring-boot-restful/target
RUN tar -xzf spring-boot-restful-1.0.0-bundle.tar.gz

FROM gcr.io/distroless/java11-debian11
COPY --from=build /app/spring-boot-restful/target/spring-boot-restful-1.0.0 /app/
# COPY --from=build /app/spring-boot-restful/deployment/docker/start.sh /app/start.sh
# WORKDIR /app
# CMD	[ "./start.sh" ]



