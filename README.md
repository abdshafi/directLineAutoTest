This Automation Framework created for Interview process.

Framework built with Following tech stack
Java
Selenium 3+
Cucumber
Maven

How to run the test ?
Clone the repostory locally
create a Junit Runner with following VM options (Framework supports running tests using firefox and chrome browsers)
-Dbrowser=firefox -Dcucumber.options="--tags @test"

Driver Executables:
GeckoDriver and ChromeDriver executable places inside /src/test/resources/drivers folder

Sample Test:
For simplicity, test written to open Moneysupermarket website and login to verify the logged in username.
PageFactory model used to initialise locators.
