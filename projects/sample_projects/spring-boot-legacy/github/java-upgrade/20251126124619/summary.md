
# Upgrade Java Project

## 🖥️ Project Information
- **Project path**: C:\Users\avina\copilot-cli\baseline-projects\Code_Analysis_Assistant-\projects\sample_projects\spring-boot-legacy
- **Java version**: 21
- **Build tool type**: Maven
- **Build tool path**: C:\softwares\mvn\bin

## 🎯 Goals

- Upgrade Java to 21
- Upgrade Spring Boot to 3.2.x

## 🔀 Changes

### Test Changes
|     | Total | Passed | Failed | Skipped | Errors |
|-----|-------|--------|--------|---------|--------|
| Before | 2 | 2 | 0 | 0 | 0 |
| After | 2 | 2 | 0 | 0 | 0 |
### Dependency Changes


#### Upgraded Dependencies
| Dependency | Original Version | Current Version | Module |
|------------|------------------|-----------------|--------|
| org.springframework.boot:spring-boot-starter-actuator | 2.0.2.RELEASE | 3.2.12 | spring-boot-sample-actuator |
| org.springframework.boot:spring-boot-starter-web | 2.0.2.RELEASE | 3.2.12 | spring-boot-sample-actuator |
| org.springframework.boot:spring-boot-starter-jdbc | 2.0.2.RELEASE | 3.2.12 | spring-boot-sample-actuator |
| com.h2database:h2 | 1.4.197 | 2.2.224 | spring-boot-sample-actuator |
| org.springframework.boot:spring-boot-configuration-processor | 2.0.2.RELEASE | 3.2.12 | spring-boot-sample-actuator |
| org.springframework.boot:spring-boot-starter-test | 2.0.2.RELEASE | 3.2.12 | spring-boot-sample-actuator |
| io.rest-assured:rest-assured | 3.0.7 | 5.3.2 | spring-boot-sample-actuator |
| org.codehaus.groovy:groovy-all | 2.4.15 | 2.4.21 | spring-boot-sample-actuator |
| Java | 8 | 21 | Root Module |

#### Added Dependencies
|   Dependency   | Version | Module |
|----------------|---------|--------|
| org.springframework.boot:spring-boot-starter-validation | 3.2.12 | spring-boot-sample-actuator |
| org.apache.httpcomponents.client5:httpclient5 | 5.2.3 | spring-boot-sample-actuator |

#### Removed Dependencies
|   Dependency   | Version | Module |
|----------------|---------|--------|
| org.apache.httpcomponents:httpclient | 4.5.5 | spring-boot-sample-actuator |

### Code commits

> There are uncommitted changes in the project before upgrading, which have been stashed.

All code changes have been committed to branch `appmod/java-upgrade-20251126124619`, here are the details:
6 files changed, 27 insertions(+), 15 deletions(-)

- 61425be -- Upgrade project to use `Spring Boot 3.2.x`, `Java 21` using openrewrite.

- ecb6851 -- Upgrade groovy-all to 2.4.21 to fix CVE-2020-17521
### Potential Issues
