
### run the binary
```
mvn clean package -Dmaven.test.skip
cd target
tar zxvf spring-boot-restful-1.0.0-bundle.tar.gz
cd spring-boot-restful-1.0.0
bin/start-console.sh
```

### Visit the Swagger Page
http://localhost:9527/swagger-ui.html

### start the mysql database on Mac OS
```
sudo /usr/local/mysql/support-files/mysql.server start
```

Init the database if needed
```
create database springboot_restful;
create user 'springbootrestfuldev'@'%' identified by 'springbootrestfuldev)(*&ASD12367';
grant all on springboot_restful.* to 'springbootrestfuldev'@'%';
flush privileges;
```

### run the test
```
mvn clean test
```

### package without running test
```
mvn clean package -Dmaven.test.skip
```