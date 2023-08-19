#!/bin/sh

java -Djava.net.preferIPv4Stack=true \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -Dconsul.host=$CONSUL_HOST \
	 -Dconsul.auth.username=$CONSUL_USER \
	 -Dconsul.auth.password=$CONSUL_PASSWORD \
	 -Dvault.host=$VAULT_HOSTNAME \
	 -Dvault.token=$VAULT_TOKEN \
	 -Dspring.config.location=file:./conf/application.yaml \
	 -Dlogging.config=file:./conf/log4j2.xml \
	 -jar ./lib/webflux-with-latency-jetty-*.jar