@smoke
Feature: Update Booking for Heroku Booking Application


  Scenario: Get List of Booking - Booking Ids
    Given Perform get "booking" request
    Then Validate 200 as the status Code

  Scenario: Update Booking Info - Booking Id
    When User re-enter details for booking
      | firstname       | Vivek        |
      | lastname        | Ranjan      |
      | totalprice      | 1101        |
      | depositpaid     | false       |
      | checkin         | 2025-03-03 |
      | checkout        | 2025-03-05 |
      | additionalneeds | Breakfast  |
    Then Perform update "booking" with "bookingid" request
    Then Validate 200 as the status Code
    And Get from response path "firstname" store in "firstname"
    And Get from response path "lastname" store in "lastname"
    And Get from response path "depositpaid" store in "depositpaid"
    And Get from response path "totalprice" store in "totalprice"
    And Get from response path "bookingdates.checkin" store in "checkin"
    And Get from response path "bookingdates.checkout" store in "checkout"
    And Validate "firstname" is "Jim"
    And Validate "totalprice" is 111
    And Validate "checkin" is "2018-01-01"