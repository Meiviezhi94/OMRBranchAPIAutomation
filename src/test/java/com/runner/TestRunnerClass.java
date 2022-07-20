package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {},monochrome = true, plugin = { "pretty",
		"json:target/cucumber.json" }, snippets = SnippetType.CAMELCASE, dryRun = false, features = "src/test/resources", glue = "com.stepdefinition")

public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\cucumber.json");
	}
}
