package org.utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void loadUrl(String Url) {
		driver.get(Url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void applyWaitAllLocators() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void fill(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void urlAssertionForInvalidLogin() {

		String url = driver.getCurrentUrl();
		Assert.assertTrue("check the url", url.contains("privacy_mutation_token"));
	}

	public static void assertionForValidLogin(WebElement element) {

		Assert.assertTrue("check the data", element.isDisplayed());
	}

	public static void takesnap(String filename) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\Admin\\ajith-workspace\\CucumberBasic\\src\\test\\resources\\Reports\\Screenshots\\"
						+ filename + ".png");
		FileUtils.copyFile(src, dest);

	}
}