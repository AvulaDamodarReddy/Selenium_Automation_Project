package com.creatio.hrm.application.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="FeatureFile",
		glue={"com.creatio.hrm.application.stepDefinitions","com.creatio.hrm.framework.base"},
		plugin={"pretty","html:Reports/AutomationReport.html"}	
		
		
		
//		        dryRun=false,    // checks mapping between scenario steps and step definition methods
//				monochrome=true,    // to avoid junk characters in output
//				publish=true  // to publish report in cucumber server
		)


public class ApplicationTestRunner extends AbstractTestNGCucumberTests {
	
	@Test
	public void run() {
		System.out.println("Running the Cucumber UI Test Scripts...");
		
	}
	
}



