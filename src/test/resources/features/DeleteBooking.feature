@smoke1
Feature: Delete Booking for Heroku Booking Application


  Scenario: Delete Booking Info - Booking Id
    When Create Auth Token
    Then Perform delete "booking" with "bookingid" request
    Then Validate 200 as the status Code