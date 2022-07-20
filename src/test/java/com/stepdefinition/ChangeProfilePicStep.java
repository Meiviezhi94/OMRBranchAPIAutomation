package com.stepdefinition;

import java.util.ArrayList;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * 
 * @author Mei
 * @creation:26/06/2022
 * @Description to change the profile picture in the application
 **/
public class ChangeProfilePicStep extends BaseClass {
	/**
	 * @Description to add headers and bearer authorization and multipart form data for accessing changeprofile pic endpoints
	 */
	@Given("User add headers and bearer authorization and multipart\\/form-data for accessing ChangeProfilepic endpoints")
	public void userAddHeadersAndBearerAuthorizationAndMultipartFormDataForAccessingChangeProfilepicEndpoints() {
		ArrayList<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer "+LoginStep.commonvariables.getLogtoken());
		h.add(h1);
		h.add(h2);
		Headers header = new Headers(h);
		addHeaders(header);
		multipart();

	}
	/**
	 * 
	 * @param string
	 * @Description to send the request type to change profile picture
	 */
	@When("User send {string} request for ChangeProfilepic")
	public void userSendRequestForChangeProfilepic(String string) {
		response = requestType("POST", Endpoints.CHANGEPROFILEPIC);	
	}
	/**
	 * 
	 * @param string
	 * @Description to verify the change profile picture response message matches the expected result
	 */
	@Then("User verify the ChangeProfilepic response messagematches {string}")
	public void userVerifyTheChangeProfilepicResponseMessagematches(String string) {
		ChangeProfilePic_Output_Pojo changeprofile_output_pojo=response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeprofile_output_pojo.getMessage();
		System.out.println(string);
		System.out.println(message);
		Assert.assertEquals("Profile updated Successfully", string, message);
		
	}

}
