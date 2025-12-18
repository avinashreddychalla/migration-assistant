# Upgrade Progress

  ### ✅ Generate Upgrade Plan [View Log](logs\1.generatePlan.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ✅ Install JDK 8
  </details>

  ### ✅ Confirm Upgrade Plan [View Log](logs\2.confirmPlan.log)

  ### ❗ Setup Development Environment [View Log](logs\3.setupEnvironment.log)
  
  
  > There are uncommitted changes in the project before upgrading, which have been stashed.
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Errors
  - Project compile failed with 1 errors. The project must be compileable before upgrading it, please fix the errors first and then invoke tool #setup\_upgrade\_environment again to setup development environment: - === Config File error     The below errors can be due to missing dependencies. You may have to refer     to the config files provided earlier to solve it.     'errorMessage': Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:compile (default-compile) on project spring-boot-sample-actuator: Fatal error compiling: invalid target release: 21    \`\`\`   Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:compile (default-compile) on project spring-boot-sample-actuator: Fatal error compiling: invalid target release: 21   \`\`\`
  
  
  - ###
    ### ✅ Install JDK 21
  </details>

  ### ✅ PreCheck [View Log](logs\4.precheck.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  - ###
    ### ❗ Precheck - Build project [View Log](logs\4.1.precheck-buildProject.log)
    
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Command
    `mvn clean test-compile -q -B -fn`
    
    #### Errors
    - === Config File error     The below errors can be due to missing dependencies. You may have to refer     to the config files provided earlier to solve it.     'errorMessage': Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:compile (default-compile) on project spring-boot-sample-actuator: Fatal error compiling: invalid target release: 21 
      ```
      Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:compile (default-compile) on project spring-boot-sample-actuator: Fatal error compiling: invalid target release: 21
      ```
    </details>
  </details>

  ### ❗ Setup Development Environment [View Log](logs\5.setupEnvironment.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Errors
  - We are not able to upgrade Java from undefined to 21 directly. Please set another compatible target versions. We only support upgrading to 21 directly from \>=8 \<21, 11, 17, please upgrade to one of these versions first.
  </details>

  ### ❗ Setup Development Environment [View Log](logs\6.setupEnvironment.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Errors
  - We are not able to upgrade Java from undefined to 21 directly. Please set another compatible target versions. We only support upgrading to 21 directly from \>=8 \<21, 11, 17, please upgrade to one of these versions first.
  </details>

  ### ❗ Setup Development Environment [View Log](logs\7.setupEnvironment.log)
  
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Errors
  - We are not able to upgrade Java from undefined to 21 directly. Please set another compatible target versions. We only support upgrading to 21 directly from \>=8 \<21, 11, 17, please upgrade to one of these versions first.
  </details>

  ### ❗ Build Project [View Log](logs\8.buildProject.log)
  Build result: 0% Java files compiled
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Command
  `mvn clean test-compile -q -B -fn`
  
  #### Errors
  - === Config File error     The below errors can be due to missing dependencies. You may have to refer     to the config files provided earlier to solve it.     'errorMessage': Some problems were encountered while processing the POMs:   'dependencies.dependency.version' for org.apache.httpcomponents:httpclient:jar is missing. @ line 54, column 15   The build could not read 1 project 
    ```
    Some problems were encountered while processing the POMs:   'dependencies.dependency.version' for org.apache.httpcomponents:httpclient:jar is missing. @ line 54, column 15   The build could not read 1 project
    ```
  </details>

  ### ✅ Fix Build Errors [View Log](logs\9.fixBuildErrors.log)
  1 file changed, 2 insertions(+), 9 deletions(-)
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Code changes
  - Removed org.apache.httpcomponents:httpclient dependency (not needed in Spring Boot 3.3.x)
  </details>

  ### ❗ Build Project [View Log](logs\10.buildProject.log)
  Build result: 0% Java files compiled
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Command
  `mvn clean test-compile -q -B -fn`
  
  #### Errors
  - package javax.validation.constraints does not exist
    ```
    [ERROR] /C:/Users/avina/copilot-cli/baseline-projects/spring-boot-legacy/src/main/java/sample/actuator/SampleController.java:[24,36] package javax.validation.constraints does not exist
    ```
  - cannot find symbol symbol:   class NotBlank location: class sample.actuator.SampleController.Message
    ```
    [ERROR] /C:/Users/avina/copilot-cli/baseline-projects/spring-boot-legacy/src/main/java/sample/actuator/SampleController.java:[70,18] cannot find symbol
    [ERROR]   symbol:   class NotBlank
    [ERROR]   location: class sample.actuator.SampleController.Message
    ```
  </details>

  ### ✅ Fix Build Errors [View Log](logs\11.fixBuildErrors.log)
  1 file changed, 1 insertion(+), 1 deletion(-)
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Code changes
  - Updated javax.validation.constraints import to jakarta.validation.constraints for Spring Boot 3.3.x compatibility
  </details>

  ### ✅ Build Project [View Log](logs\12.buildProject.log)
  Build result: 100% Java files compiled
  <details>
      <summary>[ click to toggle details ]</summary>
  
  #### Command
  `mvn clean test-compile -q -B -fn`
  </details>

  ### ⏳ Upgrade project to use `Java 21` ...Running
  
  - ###
    ### ✅ Upgrade using OpenRewrite [View Log](logs\13.1.upgradeProjectUsingOpenRewrite.log)
    1 file changed, 1 insertion(+), 1 deletion(-)
    <details>
        <summary>[ click to toggle details ]</summary>
    
    #### Recipes
    - [org.openrewrite.java.migrate.UpgradeToJava21](https://docs.openrewrite.org/recipes/java/migrate/UpgradeToJava21)
    </details>
  
    ### ⏳ Upgrade using Agent ...Running