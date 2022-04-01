TAG=1.0.0
NAME=spring-boot-openapi

app-build:
	mvn clean package -Dmaven.test.skip

app-run:
	java -Djava.net.preferIPv4Stack=true \
	 -Dspring.profiles.active=stage \
	 -Dserver.address=localhost \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -jar ./target/spring-boot-openapi-*.jar

