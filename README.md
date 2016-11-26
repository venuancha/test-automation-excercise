# test-automation-excercise
This is the automation work for the given exercise

### Technical Stack

* Java 8(But No specific feature of Java8 is used)
* Selenium Webdriver(Chrome driver is used)
* Cucumber
* Maven


### How to run the Automation

```
mvn clean test
```
- OR

```
From CucumberRunnerTest class, right click and run as Junit test(But for this please make sure project is compiled and build properly in Eclipse)
```


### Scenarios Automated

1. Create Entry
2. Delete Entry
3. Create Multiple Entries


####*Assupmption: Before running these scenarios, no content is present in the application.So before we run these scenarios please make sure that no data is present.*


####Exploratory Testing Notes
1. On MAC it works fine on Chrome and Firefox browsers but it doesn't work as expected on Windows machine

2. Bug(Major): Application doesn't run properly on Windows machine. It doesn't allow to login on Chrome and Firefox browsers in Windows. But works fine on IE11

3. Bug: No validation on any of the fields for example: Email, Phone Number etc

4. Bug: Even after we logged in when we do a search for data, on the search page header it still shows as "Login" instead of "Logout"
5. Bug: If we do not enter any data and click on "Create" button, it doesn't show any error.

