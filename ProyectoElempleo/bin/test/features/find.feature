# encoding: iso-8859-1


Feature: Login in training site
 I as a user with privileges
 want can login in my application

 
 Scenario: search  Successful
 Given That i am in the page
 When I find the data
 
 |buscar|dept|
 |contador|Bogot�|
 Then I get all jobs 
 
 
