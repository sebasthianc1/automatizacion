# encoding: iso-8859-1
Feature: to Look for employment by
  skill and city I as a user can filter by wages

Scenario: To LookFor employment
    Given That I am in the look for employ page
    And I into by skill and city
    
      | empleo    | ciudad   |
      | Contador  | Bogot�   |
      
    When I filter by wages
    
      | rangoFecha   | areaTrabajo   |
      | Hace 1 semana| Administrativa y Financiera |
      
    Then I save the job offers into a file
    And  I take Screenshot
