#!/bin/sh

nohup java -Djava.net.preferIPv4Stack=true \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -Dspring.config.location=file:./conf/application.yaml \
	 -Dlogging.config=file:./conf/log4j2.xml \
	 -jar ./lib/spring-boot-restful-*.jar > logs/app.log 2>&1 &
