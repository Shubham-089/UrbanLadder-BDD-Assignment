Feature: Urban Ladder Website Automation

  Scenario: Search for a product and attempt checkout with invalid credentials
    Given I launch the browser and navigate to the Urban Ladder homepage
    When I should see the homepage displayed correctly
    Then I search for "Sofa" and verify results
    When I should see search results related to "Sofa"
    When I apply a filter and verify updated search results
    Then I should see the search results updated according to the "Leatherette Sofa Sets" filter
    When I add a product to the cart
    Then The product should be added to the cart successfully
    When I click on the Checkout button
    And I enter valid dummy shipping details
    Then The checkout page should load successfully
