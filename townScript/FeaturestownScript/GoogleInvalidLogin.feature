Feature: Google Invalid Login

  Scenario: validating signup using invalid credentials
    
    Given: user navigates back to appurl 

    When user clicks on the Registraion its free
    And clicks on continue with google
    And enters the invalid email
    And clicks on next and checks for error message
    Then we capture the error message
