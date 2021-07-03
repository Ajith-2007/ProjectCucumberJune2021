package org.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utilities.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before

	public void beforeScenario() {

		System.out.println("Scenario starts....");
		launchBrowser();
		maximizeWindow();
		applyWaitAllLocators();
		
	}

	 //Each and every scenario file name is changing. So we will keep the scenario
//	 name as file name. There is one interface called Scenario.
	 //Creating reference for scenario using that will get the name as file name.
	
	 @After
	 public void afterScenario(Scenario s) throws IOException {
		 
		 if (s.isFailed()) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				s.embed(screenshot, "image/png");
		 }
		 
//	 String name = s.getName();
//	 takesnap(name);
	 closeBrowser();
	 System.out.println("------Scenario ends");
	 }

//	@After
//	private void afterScenario(Scenario s) {
//
//		// if failed--- True otherwise false
//		if (s.isFailed()) {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//			s.embed(screenshot, "image/png");
//			closeBrowser();
//			System.out.println("..Scenario ends");
//
//		}
//
//	}

	@Before("@smoke")
	public void beforeSmokeScenario() {
		System.out.println("Smoke Scenario starts...");
	}

	@After("@smoke")
	public void afterSmokeScenario() {
		System.out.println("....Smoke Scenario ends");
	}

	@Before("@sanity")
	public void beforeSanityScenario() {
		System.out.println("Sanity Scenario starts...");
	}

	@After("@sanity")
	public void afterSanityScenario() {
		System.out.println(".....Sanity Scenario ends");
	}

	@Before("@regression")
	public void beforeRegressionScenario() {
		System.out.println("Regression Scenario starts...");
	}

	@After

	public void afterRegressionScenario() {
		System.out.println("...Regression Scenario ends....");
	}
}
