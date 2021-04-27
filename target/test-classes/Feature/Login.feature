Feature: Login application

Scenario Outline: Login into application and verify dispalyed screen
Given Navigate into amazon application "https://www.amazon.com/"
And Verify whether and required link is displayed
When Username is provided inside signin link as <username>
Then it should return proper message
And close the browser

Examples:
| username |
| Kshethra |
|Yashmitha|
|Thanishka|

