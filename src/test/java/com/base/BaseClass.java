package com.base;

import java.io.FileInputStream;
import java.io.*;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/**
 * @author Mei
 * @description Base class created for reusable methods
 * @creation date 23/06/2022
 */

public class BaseClass {
	
	
	RequestSpecification reqSpec;
	public static Response response;

	/**
	 * @param key
	 * @param value
	 * @Description to add header
	 * @return string
	 */
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	
	/**
	 * 
	 * @param headers
	 * @Descriptin to add headers as object
	 */
	
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * @description to pass Query parameter
	 */
	
	public void queryParam(String key, String value) {
		reqSpec.queryParam(key, value);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @Description to pass path parameter
	 */

	public void pathParam(String key, String value) {
		reqSpec.queryParam(key, value);
	}
	
	/**
	 * 
	 * @param reqBody
	 * @Description to add request body
	 * 
	 */

	public void addBody(String reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
	/**
	 * @param reqBody
	 * @Description to add request body as object
	 */
	
	public void addBody(Object reqBody) {
		reqSpec = reqSpec.body(reqBody);
	}
	
	/**
	 * 
	 * @param reqType
	 * @param endPoint
	 * @return response
	 * @decription to pass the request type
	 */
	public Response requestType(String reqType, String endPoint) {
		switch (reqType) 
		{
		case "GET":
			response = reqSpec.log().all().get(endPoint);
			break;

		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;

		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;

		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}
	/**
	 * 
	 * @param response
	 * @return statuscode
	 * @Description to get the status code
	 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	/**
	 * 
	 * @param response
	 * @return body
	 * @Description to get the response body
	 */
	public ResponseBody getResponseBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}
	/**
	 * @param response
	 * @return String
	 * @description to get the response body as string
	 */

	public String getasString(Response response) {
		String asString = getResponseBody(response).asString();
		return asString;
	}
	
	/**
	 * @param response
	 * @return String
	 * @Decription to get the response body as Prettystring
	 */
	
	public String getasPrettyString(Response response) {
		String asString = getResponseBody(response).asString();
		return asString;
	}
	
	/**
	 * 
	 * @param Username
	 * @param Password
	 * @Description to pass the username and password
	 */
	public void basicAuth(String Username, String Password)
	{
		reqSpec =reqSpec.auth().preemptive().basic(Username, Password);
	}
	/**
	 * 
	 * @param key
	 * @throws IOException
	 * @throws IOException
	 * @return String
	 * @Description to get the access to propertyfile to access the confidential info
	 */
	public String getPropertyfilevalue(String key) throws IOException, IOException
	{
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\config.properties"));
		Object object = properties.get(key);
		String Value = (String) object;
		return Value;
	}
	/**
	 * @Description Used to mention the location of the image file
	 */
	public void multipart()
	{
		reqSpec = reqSpec.multiPart("profile_picture", new File("C:\\Users\\Mei\\OneDrive\\Pictures\\pic.png"));
	}
	
	
	
	
}
