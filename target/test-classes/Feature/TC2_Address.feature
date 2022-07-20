@Address
Feature: Address module API automation
	
  Scenario Outline: verify add new address to the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>", "<address>","<address_type>"
    When User send "POST" request for add new address
    Then User verify the status code is 200
    And User verify the add new address response message matches 'Address added successfully'

    Examples: 
      | first_name | last_name | mobile    | apartment | state | city | country | zipcode | address   | address_type |
      | Vasavi     | sulo      | 123456789 | abc       |    14 |   78 |      25 | "78965" | "Chennai" | "Home"       |
	
  Scenario Outline: Verify existing address is updated to the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for update existing address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>", "<address>","<address_type>"
    When User send the "PUT" request to update the existing address
    When User verify the status code is 200
    And User verify the update address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile    | apartment | state | city | country | zipcode | address   | address_type |
      | Vasavi     | sulo      | 123456789 | abc       |    14 |   78 |      25 | "78965" | "Chennai" | "Home"       |

  Scenario: Verify to Get address to the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User send the "GET" request to get the existing address
    When User verify the status code is 200
    Then User verify the get address response message matches "OK"

  Scenario: Verify to Delete address to the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User send the "DELETE" request to delete the address
    Then User verify the status code is 200
    And User verify the delete address response message matches "Address deleted successfully"
