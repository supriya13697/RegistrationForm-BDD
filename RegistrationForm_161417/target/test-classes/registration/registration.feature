#Author: Supriya

Feature: Registration Form

Scenario: Verifying the title
Given User is on registration page
Then Display Error Message 'check the title of the web page'

Scenario: User Id not entered or check the length of Id
Given User is on registration page
When User Id is empty/length should be between 5 and 12
Then Display Error Message 'Please enter User Id/check the length it should lies between 5 and 12'

Scenario: Password not entered or check the length of Id
Given User is on registration page 
When Password is empty/length should be between 7 and 12
Then Display Error Message 'Please enter Password/check the length it should lies between 7 and 12'

Scenario: Name not entered or Invalid name
Given User is on registration page 
When Name Field is empty/Invalid name 
Then Display Error Message 'Please enter Name/enter alphabet characters'

Scenario: Invalid Address
Given User is on registration page 
When Invalid address 
Then Display Error Message 'Please enter alphabetnumeric characters'

Scenario: Upon no country selected from dropdown 
Given User is on registration page 
When Upon no country selected from dropdown 
Then Display Error Message 'Please select country from list'

Scenario: Invalid Zip Code
Given User is on registration page 
When Invalid Zip Code 
Then Display Error Message 'Please enter numeric characters only'

Scenario: Enter Email ID
Given User is on registration page 
When Email Id entered

Scenario: Invalid Email ID
Given User is on registration page 
When Invalid Email Id 
Then Display Error Message 'Please enter valid email ID'

Scenario: Upon no gender selected 
Given User is on registration page 
When Upon no gender selected  
Then Display Error Message 'Please select gender'

Scenario: Select Language 

Scenario: Click on submit button 
Given User is on registration page 
When User entered valid details  
Then Display Error Message 'Your Registration with JobsWorld.com has successfully done'
