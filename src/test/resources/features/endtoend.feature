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


  Scenario Outline: Sample
    Given a user is logged in with "<UserName>" and "<Password>"

    Examples:
      | UserName     | Password        | SearchText                                                  | SelectLayer1 | SelectLayer2 | UploadFilePath       |
      | axa_admin_qa | axa_admin_qa123 | East London Waste Authority, Jenkins Lane, Barking, IG110AD | River        | Landslide    | Bulk Test Axa UK.csv |



#     qbe_admin_qa qbe_admin_qa123 40 Conyer Quay, Conyer, Sittingbourne, ME99HR Coastal Shrinkswell Bulk Test QBE.csv amlin_admin_qa amlin_admin_qa123 10 Church Street, Great Shelford, Cambridge, CB225EL Groundwater Compressible Bulk Test Amlin UK.csv lv_sv_qa lv_sv_qa123 Causeway Farm, Swinefleet, Goole, DN148DZ River Dissolution Bulk Test LV GB.csv ecclesiastical_admin_qa eccles_admin_qa123 Phantom Lover, Conyer Quay, Conyer, Sittingbourne, ME99HR Coastal Storm Bulk Test Ecclesiastical GB.csv hiscox_admin_qa hiscox_admin_qa123 23 Huntercombe Lane North, Taplow, Maidenhead, SL60LF Groundwater Running Sands Bulk Test Hiscox GB.csv sterling_su_qa sterling_su_qa123 East London Waste Authority, Jenkins Lane, Barking, IG110AD River Collapsible Bulk Test Sterling GB.csv