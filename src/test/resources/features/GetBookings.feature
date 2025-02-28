Feature: Verify Get Booking and Booking Lists for Heroku Booking Application

  Scenario: Get List of Booking
    Given User Enter details for booking
    | firstname       | Jim   |
    | lastname        | Brown |
    | totalprice      | 111   |
    | depositpaid     | true  |
    | checkin         | 2018-01-01 |
    | checkout        | 2019-01-01 |
    | additionalneeds | Breakfast |
    Then Perform post "booking" request





