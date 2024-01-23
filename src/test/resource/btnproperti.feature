Feature: BTN Calculate Maximum Property Price

@positive
Scenario: Total income is greater than expenses
	Given the user is on the property price calculation page
	When the user enters total income greater than expenses
	And the user enters expenses smaller than total income
	And the user selects a time frame
	And the user presses the calculate button
	And the user verifies the displayed data with their own formula
	Then the user successfully calculates the maximum total property price
	
@negative1
Scenario: Total income is smaller than expenses
	Given the user is on the property price calculation page
	When the user enters total income smaller than expenses
	And the user enters expenses greater than total income
	And the user selects a time frame
	Then the system displays an alert, and the save button cannot be clicked
	
@negative2
Scenario: User leaves all data empty
	Given the user is on the property price calculation page
	When the user does not fill in all the forms
	Then the save button cannot be clicked