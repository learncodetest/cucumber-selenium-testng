package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTests {

	@Given("^User is on the login screen$")
	public void userOnLoginScreen() {
		System.out.println("User is On the Login Screen");
	}

	@When("^User inputs the credentials$")
	public void userInputsCredential() {
		System.out.println("User Inputs the Credential");
	}

	@Then("^System should let him login into it$")
	public void systemLetsHimLogin() {
		System.out.println("System validates and let him login into it");
	}

}
