package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.CommonVariables;
import com.pojo.Login_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Mei
 * @Creation date:24/06/2022
 * @Description LoginStep created to login the application using baseclass methods
 *
 */
public class LoginStep extends BaseClass {
	
	public static CommonVariables commonvariables = new CommonVariables();
	
	
	String logtoken;
	
	/**
	 * @description to add header
	 */
	@Given("User add header")
	public void userAddHeader() {
		addHeader("content-type", "application/json");
	}
	
	/**
	 * @Description to add basic authentication for login to application
	 * @throws IOException
	 */
	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws IOException {
		basicAuth(getPropertyfilevalue("Username"), getPropertyfilevalue("Password"));
		
	}

	/***
	 * 
	 * @param string
	 * @Description to send the request for loginEndpoint
	 */
	
	@When("user send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String string) {
		 response = requestType("POST",Endpoints.LOGIN);
	}

	/**
	 * 
	 * @param expValue
	 * @description to verify the login response body and first name present as valid string and get the logtoken
	 */
	@Then("User verify the login response body firstname present as {string} and get the logtoken")
	public void userVerifyTheLoginResponseBodyFirstnamePresentAsAndGetTheLogtoken(String expValue) {
		Login_Output_Pojo loginoutputpojo=response.as(Login_Output_Pojo.class);
		String first_name=loginoutputpojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals("verified", expValue, first_name);
		logtoken = loginoutputpojo.getData().getLogtoken();
		System.out.println(logtoken);
		commonvariables.setLogtoken(logtoken);
		
		
		
		
		
		
		
	}

}
