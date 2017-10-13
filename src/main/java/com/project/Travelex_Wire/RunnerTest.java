package com.project.Travelex_Wire;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
				format = {"pretty", "json:target/output.json", "html:target/html"},
		features = "src/test/resource"
		
		) 
public class RunnerTest {

}
