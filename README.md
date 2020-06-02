
# test123

Clone the project:
Branch Name: test

Required for setup:

java version "1.8.0_191"
Apache Maven 3.6.3


Added dependencies in the Maven POM.XML File.

<junit.version>4.12</junit.version>
<cucumber.version>4.1.0</cucumber.version>
<selenium.version>3.14.0</selenium.version>


Drivers (Exist in the project)
Chrome Driver for Mac
Gecko Driver for Mac

Browsers: (Required)
Chrome: Version 80.0.3987.163 (Official Build) (64-bit) 
Firefox: 75.0 (64-bit)

IDE: Intellij/Eclipse
Plugins: Cucumber for Java, gherkin

How to Run Scripts:

Navigate to 
Src/test/java/com/runner/RunUITests class
Right click on it and click RunUITests option

Reports would be generated under :
/target/cucumber-html-report

