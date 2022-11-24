# estoque.api Project


Take the quarkus compiled code and package it in its distributable format, such as a JAR:
```shell script
mvn package -DskipTests
```

Create quakus image:
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus-sample-jvm .
```

Create React image:
```shell script
docker build -t estoque ./estoque
```

Create Container:
```shell script
docker-compose up
```

Site:
```shell script
http://localhost:3000/
```

teste