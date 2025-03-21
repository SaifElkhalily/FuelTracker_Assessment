Feature: This script is to Verify the basic functionality of the Fuel Tracker website

  Scenario: User can add a new fuel consumption record
    When User sets the Car Number: "1234"
    And User sets the Fuel in Liters: "10"
    And User sets the Fuel Cost: "12.5"
    And User sets the Fuel Type: "92"
    And User sets the Date "03/20/2025" and Time "10:00PM"
    And User sets the Company Id: "1212"
    And User clicks on Edit button
    Then Verify the data has been saved successfully by checking the Car Number "44444444" and the Date "2025-03-20T22:00"

  Scenario Outline: User can delete a fuel consumption record
    When User sets the Car Number: "<carNumber>"
    And User sets the Fuel in Liters: "<fuelInLiters>"
    And User sets the Fuel Cost: "<fuelCost>"
    And User sets the Fuel Type: "<fuelType>"
    And User sets the Date "<MM/dd/yyyy>" and Time "<hh:mm>"
    And User sets the Company Id: "<companyId>"
    And User clicks on Edit button
    Then Verify the data has been saved successfully by checking the Car Number "<44444444>" and the Date "<yyyy-MM-ddThh:mm>"
    And User deletes the data by clicking on the delete button for Date and Time "<yyyy-MM-ddThh:mm>"
    Then Verify the data has been deleted successfully by checking the Car Number "<44444444>" and the Date "<yyyy-MM-ddThh:mm>"

    Examples:
      | carNumber | fuelInLiters | fuelCost | fuelType | MM/dd/yyyy | hh:mm   | companyId | 44444444 | yyyy-MM-ddThh:mm |
      | 1234      | 10           | 12.5     | 92       | 03/20/2025 | 10:00PM | 1212      | 44444444 | 2025-03-20T22:00 |
      | 1235      | 15           | 12.5     | 95       | 03/21/2025 | 10:00AM | 1213      | 44444444 | 2025-03-21T10:00 |