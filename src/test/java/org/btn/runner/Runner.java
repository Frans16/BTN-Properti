package org.btn.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resource\\btnproperti.feature", 
		glue = "org.btn.definitions",
		tags = "@positiveCase",
		plugin = {}
		)

public class Runner {

}
