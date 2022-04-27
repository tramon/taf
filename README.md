This is an Automation QA Test Automation Framework sample

***

 **Technologies:**
- Gradle
- TestNg
- Selenide
- Cucumber
- Selenium WebDriver
- Slf4j + Logback
- Lombok

***

Selenide properties are stored here:
/src/main/resources/selenide.properties


**Required environment variables:**

- **env** - represent environment under test

***
 **Test Start configurations:**

Using Cucumber for Java Plugin example: 
- Main class: io.cucumber.core.cli.Main
- Definitions: definitions.google
- VM options: -Denv=qa -Dcucumber.filter.tags="@smoke-1"
- Program args:

--plugin core.cucumber.CucumberListenerPlugin  
--name "^Smoke \- Open Google calc and verify it is open$"

Using TestNg Runner example:

- Class: scenarios.SmokeTest
- VM Options: -ea -Denv=qa -Dcucumber.filter.tags="@smoke-1"

Using Gradle example:

- Run: clean test
- project: taf
- VM Options: -ea -Denv=qa -Dcucumber.filter.tags="@smoke-1"

***


