package com.pojo;
/**
 * 
 * @author Mei
 * @creation date:25/06/2022
 * @Description POJO class created to pass the input values for add address.
 */
public class Addaddress_Input_pojo {
	private String first_name;
    private String last_name;
    private String mobile;
    private String apartment;
    private int state;
    private int city;
    private int country;
    private String zipcode;
    private String address;
    private String address_type;
    
    /**
     * 
     * @param first_name
     * @param last_name
     * @param mobile
     * @param apartment
     * @param state
     * @param city
     * @param country
     * @param zipcode
     * @param address
     * @param address_type
     * @Description constructor created to pass the input values for add address.
     */
	public Addaddress_Input_pojo(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}

	/**
	 * @Description Generated Getters and setters
	 * @return String
	 */
	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getApartment() {
		return apartment;
	}


	public void setApartment(String apartment) {
		this.apartment = apartment;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getCity() {
		return city;
	}


	public void setCity(int city) {
		this.city = city;
	}


	public int getCountry() {
		return country;
	}


	public void setCountry(int country) {
		this.country = country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress_type() {
		return address_type;
	}


	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	

}
