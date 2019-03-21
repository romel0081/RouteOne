Feature:verify the RouteOne home page

  Scenario: verifying the career page search functionality

    Given user is at Route one Homepage
    When user mouse over to About Us tab
    And clicks on careers
    And clicks on search by location
    And selects U S Office
    And Enters test in the search by title text box
    Then Software Developer In Test is present in the career page
