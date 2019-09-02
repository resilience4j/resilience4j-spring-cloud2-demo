# resilience4j-spring-cloud2-demo

## Setup
If you want to use resilience4j with spring-cloud and make registries refreshable, add the Spring Cloud2 Starter of Resilience4j to your compile dependency. It makes your registries refreshable.

The module expects that `resilience4j-spring-boot2` is already provided at runtime.
```groovy
repositories {
  jCenter()
}

dependencies {
  compile "io.github.resilience4j:resilience4j-spring-boot2:${resilience4jVersion}"
  compile "io.github.resilience4j:resilience4j-spring-cloud2:${resilience4jVersion}"
}
```

## Configuration
The configuration is same with `resilience4j-spring-boot2`. You can configure registries and instances in spring-cloud-config server backend's `application.yml` config file or Spring Boot’s `application.yml` config file.

## Demo 
Setup and usage in Spring Cloud 2 with Spring Boot 2 is demonstrated into a [demo](https://github.com/resilience4j/resilience4j-spring-cloud2-demo).

There are two modules in demo. `server` module is spring-cloud-config server. It serves config files inside the `config` branch. `client` module is Spring Boot 2 application with spring-cloud-config.

### Getting Started

1. Start the `server` module.
- It works as spring-cloud-config server.
2. Start the `client` module after `server` module is up.
- `client` application will fetch `application.yml` from `server` module.                                                                                                                                                                                                                                                                                                                 

3. Request to `http://localhost:8080/check`. 
- You can see the Resilience4j's default config value in `application.yml` served by `server` module.

4. Edit some config values in `config` branch for checking changes is applied to registries.

5. Request to `http://localhost:8080/actuator/refresh` for refreshing Registry's config.
- Edited configs will be applied to registries. 

6. Request to `http://localhost:8080/check` again.
- You can see the edited config values.
