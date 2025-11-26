# Upgrade Progress

  ### ✅ Generate Upgrade Plan [View Log](logs\1.generatePlan.log)

  ### ✅ Confirm Upgrade Plan [View Log](logs\2.confirmPlan.log)

  ### ✅ Setup Development Environment [View Log](logs\3.setupEnvironment.log)
  
  
  > There are uncommitted changes in the project before upgrading, which have been stashed.

  ### ✅ PreCheck [View Log](logs\4.precheck.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Precheck - Build project [View Log](logs\4.1.precheck-buildProject.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvn clean test-compile -q -B -fn`
    </details>
  
    ### ✅ Precheck - Validate CVEs [View Log](logs\4.2.precheck-validateCves.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### CVE issues
    - Dependency `org.springframework.boot:spring-boot-starter-web` has **1** known CVEs:
      - [CVE-2022-22965](https://github.com/advisories/GHSA-36p3-wjmg-h94x): Remote Code Execution in Spring Framework
        - **Severity**: **CRITICAL**
        - **Details**: Spring Framework prior to versions 5.2.20 and 5.3.18 contains a remote code execution vulnerability known as `Spring4Shell`. 
          
          ## Impact
          
          A Spring MVC or Spring WebFlux application running on JDK 9+ may be vulnerable to remote code execution (RCE) via data binding. The specific exploit requires the application to run on Tomcat as a WAR deployment. If the application is deployed as a Spring Boot executable jar, i.e. the default, it is not vulnerable to the exploit. However, the nature of the vulnerability is more general, and there may be other ways to exploit it.
          
          These are the prerequisites for the exploit:
          - JDK 9 or higher
          - Apache Tomcat as the Servlet container
          - Packaged as WAR
          - `spring-webmvc` or `spring-webflux` dependency
          
          ## Patches
          
          - Spring Framework [5.3.18](https://github.com/spring-projects/spring-framework/releases/tag/v5.3.18) and [5.2.20](https://github.com/spring-projects/spring-framework/releases/tag/v5.2.20.RELEASE)
          - Spring Boot [2.6.6](https://github.com/spring-projects/spring-boot/releases/tag/v2.6.6) and [2.5.12](https://github.com/spring-projects/spring-boot/releases/tag/v2.5.12)
          
          ## Workarounds
          
          For those who are unable to upgrade, leaked reports recommend setting `disallowedFields` on `WebDataBinder` through an `@ControllerAdvice`. This works generally, but as a centrally applied workaround fix, may leave some loopholes, in particular if a controller sets `disallowedFields` locally through its own `@InitBinder` method, which overrides the global setting.
          
          To apply the workaround in a more fail-safe way, applications could extend `RequestMappingHandlerAdapter` to update the `WebDataBinder` at the end after all other initialization. In order to do that, a Spring Boot application can declare a `WebMvcRegistrations` bean (Spring MVC) or a `WebFluxRegistrations` bean (Spring WebFlux).
    - Dependency `org.apache.httpcomponents:httpclient` has **1** known CVEs:
      - [CVE-2020-13956](https://github.com/advisories/GHSA-7r82-7xv7-xcpj): Cross-site scripting in Apache HttpClient
        - **Severity**: **MEDIUM**
        - **Details**: Apache HttpClient versions prior to version 4.5.13 and 5.0.3 can misinterpret malformed authority component in request URIs passed to the library as java.net.URI object and pick the wrong target host for request execution.
    - Dependency `com.h2database:h2` has **2** known CVEs:
      - [CVE-2021-42392](https://github.com/advisories/GHSA-h376-j262-vhq6): RCE in H2 Console
        - **Severity**: **CRITICAL**
        - **Details**: ### Impact
          H2 Console in versions since 1.1.100 (2008-10-14) to 2.0.204 (2021-12-21) inclusive allows loading of custom classes from remote servers through JNDI.
          
          H2 Console doesn't accept remote connections by default. If remote access was enabled explicitly and some protection method (such as security constraint) wasn't set, an intruder can load own custom class and execute its code in a process with H2 Console (H2 Server process or a web server with H2 Console servlet).
          
          It is also possible to load them by creation a linked table in these versions, but it requires `ADMIN` privileges and user with `ADMIN` privileges has full access to the Java process by design. These privileges should never be granted to untrusted users.
          
          ### Patches
          Since version 2.0.206 H2 Console and linked tables explicitly forbid attempts to specify LDAP URLs for JNDI. Only local data sources can be used.
          
          ### Workarounds
          H2 Console should never be available to untrusted users.
          
          `-webAllowOthers` is a dangerous setting that should be avoided.
          
          H2 Console Servlet deployed on a web server can be protected with a security constraint:
          https://h2database.com/html/tutorial.html#usingH2ConsoleServlet
          If `webAllowOthers` is specified, you need to uncomment and edit `<security-role>` and `<security-constraint>` as necessary. See documentation of your web server for more details.
          
          ### References
          This issue was found and privately reported to H2 team by [JFrog Security](https://www.jfrog.com/)'s vulnerability research team with detailed information.
      - [CVE-2022-23221](https://github.com/advisories/GHSA-45hx-wfhj-473x): Arbitrary code execution in H2 Console
        - **Severity**: **CRITICAL**
        - **Details**: H2 Console before 2.1.210 allows remote attackers to execute arbitrary code via a jdbc:h2:mem JDBC URL containing the IGNORE_UNKNOWN_SETTINGS=TRUE;FORBID_CREATION=FALSE;INIT=RUNSCRIPT substring, a different vulnerability than CVE-2021-42392.
    - Dependency `org.codehaus.groovy:groovy-all` has **1** known CVEs:
      - [CVE-2020-17521](https://github.com/advisories/GHSA-rcjj-h6gh-jf3r): Information Disclosure in Apache Groovy
        - **Severity**: **MEDIUM**
        - **Details**: Apache Groovy provides extension methods to aid with creating temporary directories. Prior to this fix, Groovy's implementation of those extension methods was using a now superseded Java JDK method call that is potentially not secure on some operating systems in some contexts. Users not using the extension methods mentioned in the advisory are not affected, but may wish to read the advisory for further details. Versions Affected: 2.0 to 2.4.20, 2.5.0 to 2.5.13, 3.0.0 to 3.0.6, and 4.0.0-alpha-1. Fixed in versions 2.4.21, 2.5.14, 3.0.7, 4.0.0-alpha-2.
    </details>
  
    ### ✅ Precheck - Run tests [View Log](logs\4.3.precheck-runTests.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Test result
    | Total | Passed | Failed | Skipped | Errors |
    |-------|--------|--------|---------|--------|
    | 2 | 2 | 0 | 0 | 0 |
    </details>
  </details>

  ### ✅ Upgrade project to use `Spring Boot 3.2.x`, `Java 21`
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Upgrade using OpenRewrite [View Log](logs\5.1.upgradeProjectUsingOpenRewrite.log)
    6 files changed, 27 insertions(+), 15 deletions(-)
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Recipes
    - [org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2](https://docs.openrewrite.org/recipes/java/spring/boot3/upgradespringboot_3_2)
    - [org.openrewrite.java.migrate.UpgradeToJava21](https://docs.openrewrite.org/recipes/java/migrate/UpgradeToJava21)
    </details>
  
    ### ✅ Upgrade using Agent [View Log](logs\5.2.upgradeProjectUsingAgent.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Code changes
    - Applied OpenRewrite recipes for Spring Boot 3.2 upgrade\n  - Upgraded Spring Boot 3.2.x\n  - Upgraded Java 21
    </details>
  
    ### ✅ Build Project [View Log](logs\5.3.buildProject.log)
    Build result: 100% Java files compiled
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvn clean test-compile -q -B -fn`
    </details>
  </details>

  ### ✅ Validate & Fix
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ❗ Validate CVEs [View Log](logs\6.1.validateCves.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Checked Dependencies
      - org.springframework.boot:spring-boot-starter-validation:3.2.12:jar
      - org.apache.httpcomponents.client5:httpclient5:5.2.3:jar
      - org.springframework.boot:spring-boot-starter-actuator:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-web:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-jdbc:3.2.12:jar
      - com.h2database:h2:2.2.224:jar
      - org.springframework.boot:spring-boot-configuration-processor:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-test:3.2.12:jar
      - io.rest-assured:rest-assured:5.3.2:jar
      - org.codehaus.groovy:groovy-all:2.4.16:jar
      - java:*:21
    
    #### CVE issues
    - Dependency `org.codehaus.groovy:groovy-all` has **1** known CVEs need to be fixed:
      - [CVE-2020-17521](https://github.com/advisories/GHSA-rcjj-h6gh-jf3r): Information Disclosure in Apache Groovy
        - **Severity**: **MEDIUM**
        - **Details**: Apache Groovy provides extension methods to aid with creating temporary directories. Prior to this fix, Groovy's implementation of those extension methods was using a now superseded Java JDK method call that is potentially not secure on some operating systems in some contexts. Users not using the extension methods mentioned in the advisory are not affected, but may wish to read the advisory for further details. Versions Affected: 2.0 to 2.4.20, 2.5.0 to 2.5.13, 3.0.0 to 3.0.6, and 4.0.0-alpha-1. Fixed in versions 2.4.21, 2.5.14, 3.0.7, 4.0.0-alpha-2.
    </details>
  
    ### ✅ Fix CVE Issues [View Log](logs\6.2.fixCveIssues.log)
    1 file changed, 1 insertion(+), 1 deletion(-)
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Code changes
    - Upgrade groovy-all from 2.4.16 to 2.4.21\n  - Fix CVE-2020-17521 information disclosure vulnerability
    </details>
  
    ### ✅ Build Project [View Log](logs\6.3.buildProject.log)
    Build result: 100% Java files compiled
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvn clean test-compile -q -B -fn`
    </details>
  
    ### ✅ Validate CVEs [View Log](logs\6.4.validateCves.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Checked Dependencies
      - org.springframework.boot:spring-boot-starter-validation:3.2.12:jar
      - org.apache.httpcomponents.client5:httpclient5:5.2.3:jar
      - org.springframework.boot:spring-boot-starter-actuator:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-web:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-jdbc:3.2.12:jar
      - com.h2database:h2:2.2.224:jar
      - org.springframework.boot:spring-boot-configuration-processor:3.2.12:jar
      - org.springframework.boot:spring-boot-starter-test:3.2.12:jar
      - io.rest-assured:rest-assured:5.3.2:jar
      - org.codehaus.groovy:groovy-all:2.4.21:jar
      - java:*:21
    </details>
  
    ### ✅ Validate And Fix Code Behavior Changes [View Log](logs\6.5.validateBehaviorChanges.log)
  
    ### ✅ Run Tests [View Log](logs\6.6.runTests.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Test result
    | Total | Passed | Failed | Skipped | Errors |
    |-------|--------|--------|---------|--------|
    | 2 | 2 | 0 | 0 | 0 |
    </details>
  </details>

  ### ✅ Summarize Upgrade [View Log](logs\7.summarizeUpgrade.log)