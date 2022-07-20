package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Addaddress_Input_pojo;
import com.pojo.Addaddress_output_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_output_pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Mei
 * @creation date:25/06/2022
 * @Description AddressStep created to add,update,get and delete the address in the application using baseclass methods.
 *
 */

public class AddressStep extends BaseClass {
	
	static String address_id;
	
	 /**
	 * @Description to add headers
	 */
	
	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {
		ArrayList<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+ LoginStep.commonvariables.getLogtoken());
		h.add(h1);
		h.add(h2);
		Headers header = new Headers(h);
		addHeaders(header);
		}

	/**
	 * 
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 * @param string6
	 * @param string7
	 * @param string8
	 * @param int1
	 * @param string9
	 * @param string10
	 * @param string11
	 * @param string12
	 * @param string13
	 * @Description to give input data through request body for add new address
	 */
	
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string}{int}{string}, {string}Chennai{string},{string}Home{string}")
	public void userAddRequestBodyForAddNewAddressChennaiHome(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, Integer int1, String string9, String string10, String string11, String string12, String string13) {
		Addaddress_Input_pojo addaddress_Input_pojo = new Addaddress_Input_pojo
				("Vasavi", "sulo", "123456789", "abc", 14, 78, 25, "78965", "chennai", "Home");
		addBody(addaddress_Input_pojo);
		}
	
	/**
	 * 
	 * @param string
	 * @Description to send the request type to get the endpoints for add new address
	 */
	
	@When("User send {string} request for add new address")
	public void userSendRequestForAddNewAddress(String string) {
		 response = requestType("POST", Endpoints.ADDADDRESS);
	}

	/**
	 * 
	 * @param string
	 * @Description to verify the add new address response message matches with expected result
	 */
	
	@Then("User verify the add new address response message matches {string}")
	public void userVerifyTheaddnewaddressResponseMessageMatches(String string) {
		Addaddress_output_pojo addaddress_Output_pojo = response.as(Addaddress_output_pojo.class);
		String message = addaddress_Output_pojo.getMessage();
		System.out.println(message);
		System.out.println(string);
		Assert.assertEquals("verified", string, message);
		int id = addaddress_Output_pojo.getAddress_id();
		address_id = String.valueOf(id);
	}

	/**
	 * 
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @param string5
	 * @param string6
	 * @param string7
	 * @param string8
	 * @param int1
	 * @param string9
	 * @param string10
	 * @param string11
	 * @param string12
	 * @param string13
	 * @Description to add request body for update the existing address
	 */
	
	@When("User add request body for update existing address {string},{string},{string},{string},{string},{string},{string},{string}{int}{string}, {string}Chennai{string},{string}Home{string}")
	public void userAddRequestBodyForUpdateExistingAddressChennaiHome(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, Integer int1, String string9, String string10, String string11, String string12, String string13) {
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo
				(address_id, "oviya", "sundar", "789654123", "KKK Apart", 78, 52, 52, "589643", "vellore", "Home");
		addBody(updateAddress_Input_Pojo);
	
	}
	
	
	/**
	 * 
	 * @param string
	 * @Description to send the request type to update the address 
	 */
	
	@When("User send the {string} request to update the existing address")
	public void userSendTheRequestToUpdateTheExistingAddress(String string) {
		response = requestType("PUT", Endpoints.UPDATEADDRESS);
		}
	
	/**
	 * 
	 * @param string
	 * @Description to verify update address response message matches with expected result
	 */
	
	@When("User verify the update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String string) {
		UpdateAddress_output_pojo updateaddress_output_pojo = response.as(UpdateAddress_output_pojo.class);
		String message = updateaddress_output_pojo.getMessage();
		System.out.println(message);
		System.out.println(string);
		Assert.assertEquals("verified update address", string, message);
		
	}

	/**
	 * 
	 *@param string
	 *@Description to send the request get the existing address from application
	 */
	
	@When("User send the {string} request to get the existing address")
	public void userSendTheRequestToGetTheExistingAddress(String string) {
		response = requestType("GET",Endpoints.GETADDRESS);
	}
	
	/**
	 * 
	 * @param string
	 * @Description to verify the get address response message matches with expected result
	 */
	
	@Then("User verify the get address response message matches {string}")
	public void userVerifyTheGetAddressResponseMessageMatches(String string) {
		GetAddress_Output_Pojo getaddress_output_pojo = response.as(GetAddress_Output_Pojo.class);
		String message = getaddress_output_pojo.getMessage();
		System.out.println(message);
		System.out.println(string);
		Assert.assertEquals("verified Get message", string, message);
		
	}
	
	/**
	 * 
	 * @param string
	 * @Description to send the request type to delete the address
	 */
	
	@When("User send the {string} request to delete the address")
	public void userSendTheRequestToDeleteTheAddress(String string) {
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		addBody(deleteAddress_Input_Pojo);
		response = requestType("DELETE",Endpoints.DELETEADDRESS);
	}
	
	/**
	 * 
	 * @param string
	 * @Description to verify the delete address response message matches with expected result
	 */
	
	@Then("User verify the delete address response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String string) {
		DeleteAddress_output_pojo deleteAddress_Input_pojo = response.as(DeleteAddress_output_pojo.class);
		String message = deleteAddress_Input_pojo.getMessage();
		System.out.println(message);
		System.out.println(string);
		Assert.assertEquals("verified delete message", string, message);
		
	}
	}

	
