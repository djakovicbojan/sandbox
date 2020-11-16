This is a project created for purposes of job interview. It is based on Java 8 with the integration of Serenity, Selenium and Cucumber.

For GUI tests I am using Selenium with Cucumber
For API tests I am using Serenity with Cucumber

It is recommended to use **IntelliJ** community version to run a project.

To run this project you will need :  
**Java jdk 8**  
**Cucumber for java** plugin  
**Lombok** plugin  

After you clone a project, you will need to install Lombok and Cucumber for Java plugins. Go to IntelliJ menu File->Settings and in the settings go to Plugins
and in the Marketplace tab, find Lombok and Cucumber. After you restart IDE, you should see those 3 plugins installed. (*not that Gherkin is installed together with Cucumber*)

![alt text](https://imagizer.imageshack.com/img923/8320/oIfS89.png)


To run a project, you will need to run **AllTestsRunner.java** class that is located on the path src/test/java/com/htec/sandbox/runners/AllTestsRunner.java

Currently there are no tags in CucumberOptions, which means that the Runner will run all of the feature files located on the path that is given in the CucumberOptions features option.
If you want to run individual tags to run tests separately, you will need to add **tags = "@gui"** or **tags = "@api"** after the features option.

After the run, when all of the test scenarios pass, you can generate serenity report by clicking on the maven->plugins->serenity->aggregate and run it

![alt text](https://imagizer.imageshack.com/img922/9923/m0UbaD.png)

Or you can just run **mvn serenity:aggregate**

Report looks like this:  
![alt text](https://imagizer.imageshack.com/img922/7125/zPLdjm.png)
