Feature: Application Login
  I want to use Cucumber for automation testing

  Scenario: Login with valid credentials
	Given User is on the login screen
	When User inputs the credentials
	Then System should let him login into it
	
		