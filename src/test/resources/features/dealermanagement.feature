Feature: Dealer Management



  Scenario: User can navigate to dealer management

    Given user is logged into CSB
    When he navigates to "Dealer Management"
    Then he should be in see the title as "ViewDealers"
    And list of dealer should be visible


  Scenario: User can navigate to add dealer management

    Given user is logged into CSB
    When he navigates to "Dealer Management"
    When he want to add new Dealer
    Then he should be in see the title as "Add Dealers"


    Scenario Outline: User cannot add dealer with invalid details

      Given user is logged into CSB
      When he navigates to "Dealer Management"
      When he want to add new Dealer
      And he enters
      |Dealer Code|<Dealer Code>|
      |Firm Name  |<Firm Name>  |
      |Address    |<Address>    |
      |City       |<City>       |
      |State      |<State>      |
      |Pin code   |<Pin code>   |
      |Owner Name |<Owner Name> |
      |E-mail     |<E-mail>     |
      |Telephone  |<Telephone>  |
      |Mobile No  |<Mobile No>  |
      |Dealership Date|<Dealership Date>|
      |Credit Limit   |<Credit Limit>   |
      |Stock Point1   |<Stock Point1>   |
      |Stock Point2   |<Stock Point2>   |
      |Sales Person Name|<Sales Person Name>|
      |Sales Person Mobile No|<Sales Person Mobile No>|
      |Sales Person Address  |<Sales Person Address>  |
      |Sales Person E-mail   |<Sales Person E-mail>   |

      Then a message should be shown

      Examples:
        |Dealer Code|Firm Name  |Address    	|City      	|State     	|Pin code   |Owner Name |E-mail    	|Telephone 	|Mobile No 	|Dealership Date|Credit Limit   ||Stock Point1   	|Stock Point2   |Sales Person Name|Sales Person Mobile No|Sales Person Address  	|Sales Person E-mail  |
        |Dealer Code|Firm Name  |Address    	|City      	|State     	|Pin code   |Owner Name |E-mail    	|Telephone 	|Mobile No 	|Dealership Date|Credit Limit   ||Stock Point1   	|Stock Point2   |Sales Person Name|Sales Person Mobile No|Sales Person Address  	|Sales Person E-mail  |







