# Artifact Upload Demo

This is a simple Spring Boot client-server application for PoC/demo upload of the files from client to server.

## Features

* Run a Java/Spring Boot/Tomcat server to accepts the incoming connections.
* Run a command-line client that uploads the specified file and exits. 

## Quick Start

### Start The Server

1. Edit `src/main/resources/application.properties` to configure
  - destination artifact directory (`file.upload-dir`). Make sure the specified directory exists.
  - (optional) server port (`server.port`).
2. Start the server:

```Shell
mvn spring-boot:run
```

### Run The Client

#### On Linux

1. Download and install dependencies:

```Shell
mvn clean install
```

2. Run the client (upload a file):

```Shell
SERVER_URL="http://localhost:8080" # Change if needed
CLASS_PATH="target/classes:target/dependency/httpclient-4.5.13.jar:target/dependency/httpcore-4.4.16.jar:target/dependency/httpmime-4.5.13.jar:target/dependency/commons-logging-1.2.jar"
CLIENT_CLASS="com.example.artifactuploaddemo.client.ArtifactUploadClient"
java -cp $CLASS_PATH $CLIENT_CLASS $SERVER_URL <filename_to_upload>
```

#### On Windows

1. Download and install dependencies:

```PowerShell
mvn clean install
```

2. Run the client (upload a file):

```PowerShell
$serverUrl = "http://localhost:8080" # Change if needed
$classPath = "target/classes;target/dependency/httpclient-4.5.13.jar;target/dependency/httpcore-4.4.16.jar;target/dependency/httpmime-4.5.13.jar;target/dependency/commons-logging-1.2.jar"
$clientClass = "com.example.artifactuploaddemo.client.ArtifactUploadClient"
java.exe -cp $classPath $clientClass $serverUrl <filename_to_upload>
```

## Development

This section is generated automatically by [Spring Initializr](https://start.spring.io/).

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

