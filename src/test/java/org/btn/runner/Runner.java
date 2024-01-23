package org.btn.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resource\\btnproperti.feature", 
		tags = "",
		glue = "org.btn.definitions",
		plugin = {"html:target/cucumber-reports/testResult.html"},
		monochrome = true
	)

public class Runner {
	
}
