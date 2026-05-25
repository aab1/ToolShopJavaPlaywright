Feature: Home page

  Scenario: navigate from home to contact page
    Given user navigates to the home page
    When user clicks contact nav
    Then the contact page is displayed