package com.pojo;

import java.util.ArrayList;

public class GetAddress_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<GetAddress_data_pojo> data;
	
	
//	public GetAddress_Output_Pojo(int status, String message, GetAddress_data_pojo data) {
//		super();
//		this.status = status;
//		this.message = message;
//		this.data = data;
//	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<GetAddress_data_pojo> getData() {
		return data;
	}
	public void setData(ArrayList<GetAddress_data_pojo> data) {
		this.data = data;
	}
	
	
}
