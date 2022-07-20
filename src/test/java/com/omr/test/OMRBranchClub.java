
package com.omr.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Addaddress_Input_pojo;
import com.pojo.Addaddress_output_pojo;
import com.pojo.ChangeProfilePic_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_output_pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.GetAddress_data_pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_output_pojo;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.channelSpec_return;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OMRBranchClub extends BaseClass {
	String logtoken;
	String address_id;
	@Test(priority=1)
	public void login() throws IOException
	{
	    addHeader("content-type", "application/json");
		basicAuth(getPropertyfilevalue("Username"), getPropertyfilevalue("Password"));
		Response response = requestType("POST",Endpoints.LOGIN);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify StatusCode");
		
		Login_Output_Pojo loginoutputpojo=response.as(Login_Output_Pojo.class);
		String first_name=loginoutputpojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Meiviezhi", "verify firstName");
		logtoken = loginoutputpojo.getData().getLogtoken();
		}
	@Test(priority=2)
	public void addAddress()
	{
		ArrayList<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		h.add(h1);
		h.add(h2);
		Headers header = new Headers(h);
		addHeaders(header);
		Addaddress_Input_pojo addaddress_Input_pojo = new Addaddress_Input_pojo
				("Vasavi", "sulo", "123456789", "abc", 14, 78, 25, "78965", "chennai", "Home");
		addBody(addaddress_Input_pojo);
		Response response2 = requestType("POST", Endpoints.ADDADDRESS);
		int statusCode = getStatusCode(response2);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		Addaddress_output_pojo addaddress_Output_pojo = response2.as(Addaddress_output_pojo.class);
		String message = addaddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address added successfully", "Add address verified");
	
		int id = addaddress_Output_pojo.getAddress_id();
		address_id = String.valueOf(id);
	}
	
		
		@Test(priority = 3)
		public void updateAddress()
		{
			ArrayList<Header> h = new ArrayList<Header>();
			Header h1 = new Header("Content-Type", "application/json");
			Header h2 = new Header("Authorization", "Bearer "+logtoken);
			h.add(h1);
			h.add(h2);
			Headers header = new Headers(h);
	
			addHeaders(header);
			
			UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo
					(address_id, "oviya", "sundar", "789654123", "KKK Apart", 78, 52, 52, "589643", "vellore", "Home");
			addBody(updateAddress_Input_Pojo);
		
			Response response2 = requestType("PUT", Endpoints.UPDATEADDRESS);
			int statusCode = getStatusCode(response2);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200,"Verify status code");
			
			UpdateAddress_output_pojo updateaddress_output_pojo = response2.as(UpdateAddress_output_pojo.class);
			String message = updateaddress_output_pojo.getMessage();
			System.out.println(message);
			Assert.assertEquals(message, "Address updated successfully", "update address verified");
		
		}
		@Test(priority = 4)
		public void getAddress()
		{
			List<Header> h = new ArrayList<Header>();
			Header h1 = new Header("Content-Type", "application/json");
			Header h2 = new Header("Authorization", "Bearer "+logtoken);
			h.add(h1);
			h.add(h2);
			Headers header = new Headers(h);
	
			addHeaders(header);
			Response response = requestType("GET",Endpoints.GETADDRESS);
			int statusCode = getStatusCode(response);
			Assert.assertEquals(statusCode,200, "Verify status code");
			System.out.println(statusCode);
			GetAddress_Output_Pojo getaddress_output_pojo = response.as(GetAddress_Output_Pojo.class);
			String message = getaddress_output_pojo.getMessage();
			Assert.assertEquals(message, "OK","verify ok");
		
		
		
		
		}

		@Test(priority = 5)
		public void deleteAddress()
		{
			ArrayList<Header> h = new ArrayList<Header>();
			Header h1 = new Header("Content-Type", "application/json");
			Header h2 = new Header("Authorization", "Bearer "+logtoken);
			h.add(h1);
			h.add(h2);
			Headers header = new Headers(h);
	
			addHeaders(header);
			DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
			addBody(deleteAddress_Input_Pojo);
			Response response = requestType("DELETE",Endpoints.DELETEADDRESS);
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "verify status code");
			
			DeleteAddress_output_pojo deleteAddress_Input_pojo = response.as(DeleteAddress_output_pojo.class);
			String message = deleteAddress_Input_pojo.getMessage();
			Assert.assertEquals(message, "Address deleted successfully", "Verify address deleted successfully");
		}
		
		@Test(priority = 6)
		public void changeProfilePic()
		{
			ArrayList<Header> h = new ArrayList<Header>();
			Header h1 = new Header("Content-Type", "multipart/form-data");
			Header h2 = new Header("Authorization", "Bearer "+logtoken);
			h.add(h1);
			h.add(h2);
			Headers header = new Headers(h);
			addHeaders(header);
			multipart();
			Response response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200, "Verify status code");
			ChangeProfilePic_Output_Pojo changeprofile_output_pojo=response.as(ChangeProfilePic_Output_Pojo.class);
			String message = changeprofile_output_pojo.getMessage();
			Assert.assertEquals(message, "Profile updated Successfully" , "Profile uploaded successfully");
			}
		
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	





























