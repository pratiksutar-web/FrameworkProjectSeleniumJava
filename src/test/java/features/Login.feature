Feature: Login functionality of Tutorials Ninja

Scenario: Test login functionality with valid credentials
Given Open any browser
And Go to the application url and navigate to login page
When User enter username as "pratikjsutar@gmail.com" and password as "pratik" into fields
And User click on the Login button
Then User should be logged in to the system successfully
