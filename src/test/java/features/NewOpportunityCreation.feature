Feature: Create new opportunity

  Background: :
	Given I am on the login page
	When I enter the username and password
	Then I am logged in successfully

	Scenario: Creating new opportunity
	  Given I click on the App button
	  When I click on the New button
	  And I Enter the details
	  Then I see that the details are saved