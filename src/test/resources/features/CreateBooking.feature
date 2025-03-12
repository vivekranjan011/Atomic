@smoke123
Feature: Verify Create Booking for Heroku Booking Application

  Scenario Outline: Create Booking
#    Given User Enter details for booking
    Given User Enter details for booking payload
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | totalprice      | <totalprice>      |
      | depositpaid     | <depositpaid>     |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    Then Perform post "booking" request
    And Validate <status> as the status Code
    And Get from response path "bookingid" store in "bookingid"
    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds | status |
      | Jim       | Ranjan   | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       | 200    |






