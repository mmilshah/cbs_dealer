@prod
Feature: Product Management

  Scenario: Admin should be able to View Product Details
  Given admin is in dashboard CSB
  When he navigates to "Product Management - Product List" page
  Then the page title should be "ViewProductDetails"
  And he should see atleast 1 product from the list


#  Scenario: Admin should be able to navigate to Add Product Page
#    Given user is logged into CSB
#    When he navigates to "Product Management- Product List"
#    When he want to Add New Product
#    Then he should see the title as "Add Product"
#
#
  Scenario Outline: Admin Should be able to Add New Product With all Valid Data

    Given Admin is on "Add Product" Page
    When Admin Enters All Valid Data
    When He tries To "Save" that data
    Then He should see a message "New Product Added Successfully"
    When Admin comes back to "View Product Details"
    Then he should see same record in 'Product List'

  Examples:

  | Item Code | Model  | Category      | Sub Category | Description | DealerBasic | MRP  | Warranty | Image    | Status |
  | 101       | IG-123 | Ups Batteries | Solar        | Test Data   | 1000        | 1250 | 12Months | demo.jpg | Active |

#  " Admin Should not be able to Add New Product With
#  InValid Data"	" Given Admin is on ""Add Product"" Page
#    When Admin Enters All InValid Data
#    When He tries To ""Save"" that data
#    Then He should see an error message ""Invalid Data""
#    And only Invalid Data Field Should be Highlighted/ Reset
#    And He should not be able to Save untill all Data is Valid
#
#    Examples:
#
#      | Item Code | Model  | Category      | Sub Category | Description | DealerBasic | MRP  | Warranty | Image    | Status |
#      | 101       | IG-123 | Ups Batteries | Solar        | Test Data   | 1000000     | 1250 | 12Months | demo.txt | Active |

