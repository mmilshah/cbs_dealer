@moon
Feature: Maps


  @moon
  Scenario Outline: login and check user can see the dash board


    Given user logged in with "<UserName>" and "<Password>"
    Then he should be in home page
    When he search for a "<Search Text>" address


    Examples:

      | UserName     | Password        | Search Text                                                 | SelectLayer1 | SelectLayer2 | UploadFilePath       |
      | axa_admin_qa | axa_admin_qa123 | East London Waste Authority, Jenkins Lane, Barking, IG110AD | River        | Landslide    | Bulk Test Axa UK.csv |

    @test
    Examples:

      | UserName     | Password        | Search Text                                                 | SelectLayer1 | SelectLayer2 | UploadFilePath       |
      | qbe_admin_qa | qbe_admin_a123 | 40 Conyer Quay, Conyer, Sittingbourne, ME99HR               | Coastal      | Shrinkswell  | Bulk Test QBE.csv    |






