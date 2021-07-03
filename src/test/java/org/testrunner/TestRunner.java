package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilities.JvmReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\FeatureFiles",glue="org.stepdefinition", dryRun=false,
monochrome=true,snippets=SnippetType.CAMELCASE, tags = {"@Login" },
plugin = {"pretty",
		"html:src\\test\\resources\\Reports",
		"json:src\\test\\resources\\Reports\\output.json",
		"junit:src\\test\\resources\\Reports\\fb.xml",
		"rerun:src\\test\\resources\\Failed\\failedscenarios.txt"})


public class TestRunner {
	
	//feature=feature files folder location
	//glue= step definition package name
	
@AfterClass	

public static void jvmReportGeneration() {

	JvmReports.generateJvmReport(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\output.json");
}

} 