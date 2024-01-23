package org.btn.definitions;

import org.btn.util.HelperClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public static void setup(Scenario scenario) {
		HelperClass.setUpDriver();
		System.out.println("");
		System.out.println("Scenario Name: "+scenario.getName());
		System.out.println("========================================");
	}
	
	
	@AfterStep
	public static void takeScreenshoot(Scenario scenario) {
		final byte[] screenshoot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshoot, "image/png", scenario.getName());
	}
	
	@AfterAll
	public static void tearDown() {
		HelperClass.tearDown();
	}
}
