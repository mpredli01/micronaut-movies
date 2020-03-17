## OCI Releases Micronaut 1.3 Featuring Micronaut Data 1.0

### InfoQ Java Queue

#### published March 18, 2020

This example demonstrates a Micronaut Data using SQL/JDBC.

## Example Structure

* `src/main/java/org/redlich/movies/domain` - Entities that map onto database tables.
* `src/main/java/org/redlich/movies/repositories` - Micronaut Data Repository interfaces.
* `src/main/java/org/redlich/movies/controllers` - Controllers that are injected with the repository interfaces.
* `src/test/java/org/redlich/movies` - JUnit 5 tests that test the application.

## Example Configuration

The example is configured to use an in-memory H2 database via `src/main/resources/application.yml`.

The schema is set to generate automatically using the `schema-generate: CREATE_DROP` setting.

Query logging is enabled in `src/main/resources/logback.xml` via:

```xml
<logger name="io.micronaut.data.query" level="debug" />
```

## Running the example

You can run the tests with either `./gradlew test` for Gradle or `./mvnw test` for Maven.

The application can be run with either `./gradlew run` or `./mvnw compile exec:exec`. 

Alternatively you can import the example into either IntelliJ, Visual Studio Code or Eclipse.

```bash
$ curl -w "\n" http://localhost:8080/movies/The%20Green%20Mile
```

## Native Image

A native image can be built by installing GraalVM 19.1 or above and running the following for Gradle:

```bash
$ ./gradlew assemble 
$ native-image --no-server -cp build/libs/micronaut-movies-0.1-all.jar
```

Or for Maven:

```bash
$ ./mvnw package 
$ native-image --no-server -cp target/micronaut-movies-0.1.jar
```

 