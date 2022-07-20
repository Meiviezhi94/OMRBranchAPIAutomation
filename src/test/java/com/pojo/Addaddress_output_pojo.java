package com.pojo;
/**
 * 
 * @author Mei
 * @creation date:25/06/2022
 * @Description POJO class created to get the output values or response body for add address.
 */
public class Addaddress_output_pojo {
	
	    private int status;
	    private String message;
	    private int address_id;
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
		public int getAddress_id() {
			return address_id;
		}
		public void setAddress_id(int address_id) {
			this.address_id = address_id;
		}
	


}
