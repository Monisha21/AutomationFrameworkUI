Feature: Elements Page funtionality

  @Elements
  Scenario: Verify Textbox module
    Given Provide values in textbox in elements page and submit
    And verify textbox success message

    Scenario: Verify Checkbox module
      Given Check and Uncheck nested checkboxes
      Then verify how many checkboxes checked in total
      And verify checkbox success message