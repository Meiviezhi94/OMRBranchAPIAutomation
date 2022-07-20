package com.pojo;
/**
 * 
 * @author Mei
 * @creation date:25/06/2022
 * @Description POJO class created for change profile picture output
 */


public class ChangeProfilePic_Output_Pojo {

	private int status;
	private String message;
	private Dataprofilepic data;
	private int cart_count;
	public int getStatus() {
		return status;
	}
	
	/**
	 * 
	 * @param status
	 * @Description Generated Getters and setters
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Dataprofilepic getData() {
		return data;
	}
	public void setData(Dataprofilepic data) {
		this.data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	
	
}
