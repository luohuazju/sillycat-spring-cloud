TAG=1.0.0
NAME=spring-boot-api

app-build:
	mvn clean package -Dmaven.test.skip

app-run:
	java -Djava.net.preferIPv4Stack=true \
	 -Dspring.profiles.active=stage \
	 -Dserver.address=centos7-master \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -jar ./target/spring-boot-api-*.jar

build:
	docker build -f deployment/docker/Dockerfile -t $(NAME):$(TAG) .

run:
	docker run -d --network host --name $(NAME) $(NAME):$(TAG)
	
debug:
	docker run -ti --network host --name $(NAME) $(NAME):$(TAG) /bin/bash

clean:
	docker stop $(NAME)
	docker rm $(NAME)