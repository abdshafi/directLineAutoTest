# BlackCat Technical Test for QA Automation

The candidate needs to write a Selenium Webdriver test using Cucumber in Java to perform a critical test that will verify that the website https://e.ggtimer.com/ behaves as expected. The website has the ability to set a countdown timer of the users choosing in either seconds (default), minutes or hours. The time for this exercise should be time boxed to 1 hour.

## Things to consider

* Candidates can pair with the interviewer if they wish or perform the task on their own
* First create your new changes on a separate branch from master
* Once your changes are done, commit them and push them to the repository
* The test should run on Chrome or Firefox and pass 3 consecutive runs


## Extension

What other scenarios could be tested for this application?
What improvements could be made to the test framework?
Could this be tested in a different way?


## Notes about the Test Framework

This Test Framework is built with Following tech stack:
* Java
* Selenium 3+
* Cucumber
* Maven

### How to run the tests

* Clone the repostory locally (git clone https://bothi@bitbucket.org/bothi/testautomation.git)
* Create a Junit Runner with following VM options (Framework supports running tests using latest firefox and chrome browsers)
* Runner Class to be selected is : com.blackcat.CucumberRunner
    `-Dbrowser=firefox -Dcucumber.options="--tags @test"`

#### Driver Executables:
GeckoDriver and ChromeDriver executable are placed inside `/src/test/resources/drivers` folder

#### Sample Test:
For simplicity, a test written to open the Moneysupermarket website and login to verify the logged in username.
PageFactory model is used to initialise locators.
