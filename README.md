# resilience4j-spring-cloud2-demo

**⚠️ resilience4j-spring-cloud2 is not released yet. It is [in progress](https://github.com/resilience4j/resilience4j/pull/550).**

This demo shows how to use the fault tolerance library Resilience4j in a Spring Boot 2 application with Spring Cloud.

* `client` module : spring-cloud-config-client.
* `server` module : spring-cloud-config-server. 

## Getting Started
On this demo, `server` module serve `application.yml` in `config` branch.

1. Fork this repo.

2. Start the `server` module through the main class.

3. Start the `client` module after `server` module is up.

4. Request to `http://localhost:8080/check`. 
- You can see the Resilience4j's default config value in `application.yml`.

5. Edit some config values in `config` branch.

6. Request to `http://localhost:8080/actuator/refresh` for refreshing Registry's config.

7. Request to `http://localhost:8080/check` again.
- You can see the edited config values. 
