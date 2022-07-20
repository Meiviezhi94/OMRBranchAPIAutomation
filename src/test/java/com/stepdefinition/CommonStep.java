package com.stepdefinition;

import org.junit.Assert;

//import static org.testng.Assert.assertEquals;

//import org.testng.Assert;

import com.base.BaseClass;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class CommonStep extends BaseClass {
	
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int statuscode) {
		int statusCode = getStatusCode(response);
		LoginStep.commonvariables.setStatuscode(statusCode);
		System.out.println(LoginStep.commonvariables.getStatuscode());
		Assert.assertEquals("verify status code", statuscode, LoginStep.commonvariables.getStatuscode());
		
	}

}
