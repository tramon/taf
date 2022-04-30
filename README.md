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

To run Tests remotely using browserstack you need:
(this file is ignored by git and wil only be stored in your own local PC)
1. pass a Runtime variable (like env) remote=true
 example: -Dremote=true
2. create a browserstack.properties file
3. populate it with your PERSONAL browserstack username:
   example: browserstack.username=authorUserName
4. populate it with your PERSONAL browserstack access key
   example: browserstack.access.key=someAccessKeyProvidedByBrowserStack

so the filename will be browserstack.properties
it will be in a root folder

the resulting file will consist of two properties:
- browserstack.username=authorUserName
- browserstack.access.key=someAccessKeyProvidedByBrowserStack

***

Browser Stack screenshots are stored here: build/reports/tests

***

