Feature: End and End tests

@run
  Scenario: User should be able to do a single product shopping and get a order number

    Given user is in home page
    When he opens the "MEN" section
    When he navigates to "SHOP" section
    And selects the product with title "Gucci"
    And adds the item to the basket
    Then opens continue till the payment
    And pay with a new card
    Then payment should be successful
