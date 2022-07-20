package com.payLoad;

import com.pojo.Addaddress_Input_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
	/**
	 * 
	 * @author Mei
	 * @creation date 25/06/2022 
	 * @Decription
	 */
public class PayLoad {
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
	 * @return String
	 * @Description to pass the input values for add address method
	 */
	public static Addaddress_Input_pojo createAddress(String first_name, String last_name, String mobile, String apartment, int state, int city, int country,String zipcode,String address, String address_type)
	{
		Addaddress_Input_pojo addaddress_Input_pojo = new Addaddress_Input_pojo(first_name,last_name,mobile,apartment,state,city,country,zipcode,address,address_type);
		return addaddress_Input_pojo;
	}
	/**
	 * 
	 * @param address_id
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
	 * @return String
	 * @Description to pass the input values for update address method
	 */
	public static UpdateAddress_Input_Pojo updateAddress(String address_id, String first_name, String last_name, String mobile, String apartment, int state, int city, int country,String zipcode,String address, String address_type)
	{
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(address_id,first_name,last_name,mobile,apartment,state,city,country,zipcode,address,address_type);
		return updateAddress_Input_Pojo;
	}
	/**
	 * 
	 * @param address_id
	 * @return String
	 * @Description to pass the address_id for delete address method
	 */
	public static DeleteAddress_Input_Pojo deleteAddress(String address_id)
	{
		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		return deleteAddress_Input_Pojo;
		
	}
	
	
}
