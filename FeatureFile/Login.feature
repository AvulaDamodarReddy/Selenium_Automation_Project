Feature: Login feature in OrangeHRM

  Background: Initialize page classes
    Given Initialize the page objects

  Scenario Outline: Verify login functionality with <Scenario>
    Given User Launch the Application
    And Verify Login page is displayed
    When User enters <username> and <password>
    And User clicks on the Login button
    Then Login should be successful

    Examples: 
      | Scenario | username | password |
      | Valid    | Admin    | admin123 |

  Scenario Outline: Verify logout functionality
    Given User Launch the Application
    And Verify Login page is displayed
    When User enters <username> and <password>
    And User clicks on the Login button
    Then Login should be successful
    When Clicks on the user profile icon
    And User select the Logout option
    Then Verify Login page is displayed

    Examples: 
      | Scenario | username | password |
      | Valid    | Admin    | admin123 |
