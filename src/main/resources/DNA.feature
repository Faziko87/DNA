Feature:Navigate through this flow and provide the following Tests as described below

  Scenario:
    When Navigate to the BrainPOP Homepage
    When Log in with the above username and password
    Then Enter and submit the following Search query: Challenge
    Then Select the Topic DNA from the search Results page
    And Perform various actions with the movie player
    Then Select a Feature associated with the Topic

    When Validate whether the number of Topics returned matches the amount of Topics reported in Topics (X Results)
    Then Confirm that the User can play the Movie and see its End Screen
    And Validate that the Closed Caption feature can be toggled [On and Off]
    Then Select the Related Reading Feature from the Features list
    Then Generalize that function to select any Future from the Topic page

