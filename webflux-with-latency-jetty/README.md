###Build the Project

```
mvn clean package
```

###Start the Service

```
cd target
tar zxvf webflux-with-latency-jetty-1.0.0-bundle.tar.gz
cd webflux-with-latency-jetty-1.0.0
ls -l
bin/start-console.sh
```


Visit the docs

http://localhost:8082/swagger-ui.html