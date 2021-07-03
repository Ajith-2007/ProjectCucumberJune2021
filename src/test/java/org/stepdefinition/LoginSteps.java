package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.objectrepository.LoginPojo;
import io.cucumber.datatable.DataTable;
import org.utilities.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {


	@Given("User is in facebook login page")
	public void user_is_in_facebook_login_page() {
		launchBrowser();
		loadUrl("https://en-gb.facebook.com/");
	}

	@When("User enters invalid {string} and {string}")
	public void user_enters_invalid_and(String email, String pass) throws InterruptedException {

		LoginPojo l1 = new LoginPojo();
		fill(l1.getTxtEmail(), email);
		fill(l1.getTxtPass(), pass);
		Thread.sleep(3000);
	}

	@When("User click login button")
	public void user_click_login_button() throws InterruptedException {
		LoginPojo l2 = new LoginPojo();
		btnClick(l2.getBtnLogin());
		Thread.sleep(3000);
	}
	
	//one dimensional with header
	@When("User enter invalid username and password")
	public void user_enter_invalid_username_and_password(DataTable d) throws InterruptedException {
		
		List<Map<String, String>> list = d.asMaps();
		Map<String, String> map = list.get(2);
		String username = map.get("username");
		String password = map.get("password");
		
		LoginPojo l1 = new LoginPojo();
		fill(l1.getTxtEmail(), username);
		fill(l1.getTxtPass(), password);
		Thread.sleep(3000);
	    
	}

	@Then("User must be in invalid credentials page")
	public void user_must_be_in_invalid_credentials_page() {
		urlAssertionForInvalidLogin();
	}

	@Then("User must be validate the results based on {string}")

	public void user_must_be_validate_the_results_based_on(String type) {

		if (type.equals("positive")) {
			LoginPojo l3 = new LoginPojo();
			assertionForValidLogin(l3.getBtnLogout());
		}

		else if (type.equals("negative")) {
			urlAssertionForInvalidLogin();

		}
			}
	
	@Given("User click forgot password link")
	public void user_click_forgot_password_link() {
	    System.out.println("user clicked login button");
	}

	@When("User enter invalid email id for finding the connected account")
	public void user_enter_invalid_email_id_for_finding_the_connected_account() {
	    System.out.println("user entered email id");
	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
	    System.out.println("user clicked search button");
	}

	@Then("user must validate the error message")
	public void user_must_validate_the_error_message() {
	    System.out.println("user validate the message for invalid emailid");
	}

	@When("User enter invalid mobile number for finding the connected account")
	public void user_enter_invalid_mobile_number_for_finding_the_connected_account() {
	  System.out.println("user enter invalid mobile number");  
	}

	@Then("user must validate the error message for invalid mobile number")
	public void user_must_validate_the_error_message_for_invalid_mobile_number() {
	    System.out.println("user validate the error message for invalid mobile number");
	}

	}


