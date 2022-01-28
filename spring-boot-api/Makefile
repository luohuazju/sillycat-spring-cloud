TAG=1.0.0
NAME=spring-boot-api

app-build:
	mvn clean package -Dmaven.test.skip

app-run:
	java -Djava.net.preferIPv4Stack=true \
	 -Dspring.profiles.active=dev \
	 -Dserver.address=centos7-master \
	 -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
	 -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
	 -jar ./target/spring-boot-api-*.jar

app-run-stage:
        java -Djava.net.preferIPv4Stack=true \
         -Dspring.profiles.active=stage \
         -Dserver.address=centos7-master \
         -XX:MaxMetaspaceSize=256M -XX:+HeapDumpOnOutOfMemoryError \
         -XX:HeapDumpPath="/tmp/dump_oom.hprof" \
         -jar ./target/spring-boot-api-*.jar
