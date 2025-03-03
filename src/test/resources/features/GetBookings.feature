@smoke
Feature: Verify Get Booking and Booking Lists for Heroku Booking Application


  Scenario: Get List of Booking - Booking Ids
    Given Perform get "booking" request
    Then Validate 200 as the status Code

  Scenario: Get Booking Info - Booking Id
    Given Perform get "booking" with "bookingid" request
    Then Validate 200 as the status Code
    And Get from response path "firstname" store in "firstname"
    And Get from response path "lastname" store in "lastname"
    And Get from response path "firstname" store in "depositpaid"
    And Get from response path "bookingdates.checkin" store in "checkin"
    And Get from response path "bookingdates.checkout" store in "checkout"
    And Validate "firstname" is "Jim"
    And Validate "totalprice" is 111
    And Validate "checkin" is "2018-01-01"







