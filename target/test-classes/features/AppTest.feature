Feature: Add new Api app

Scenario: User should be able to add API app

Given User is login into Fiserv Developer Portal using <username> and <Password>
And click on login button
When user selects the API Apps table to developer portal
And user clicks on Add API App button to create an app
And user inputs the <AppName>, <Discription> and <Environment> to create the app 
Then user clicks on confirm button, to create the app successfully 
And app should be created successfully having <AppName> and <Environment>

Examples:
 |  username                 |  Password  | AppName |Discription |Environment|
 |Yukti_tahilramani@yahoo.com|Ireland@2021|TestApp  |Creating APP|Sandbox    |