### Build

```
mvn clean package -Dmaven.test.skip
```

### Run

```
java -Djava.net.preferIPv4Stack=true -Dspring.profiles.active=dev -jar ./target/spring-boot-api-*.jar
```
