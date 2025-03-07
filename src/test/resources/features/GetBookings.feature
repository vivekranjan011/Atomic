@smoke
Feature: Verify Get Booking and Booking Lists for Heroku Booking Application


  Scenario: Get List of Booking - Booking Ids
    Given Perform get "booking" request
    Then Validate 200 as the status Code

  Scenario Outline: Get Booking Info - Booking Id
    Given Perform get "booking" with "bookingid" request
    Then Validate 200 as the status Code
    And Extract below data from the response
      | firstname             | firstname   |
      | lastname              | lastname    |
      | depositpaid           | depositpaid |
      | totalprice            | totalproce  |
      | bookingdates.checkin  | checkin     |
      | bookingdates.checkout | checkout    |
    And Validate "firstname" is "<firstname>"
    And Validate "lastname" is "<lastname>"
    And Validate "totalprice" is <totalprice>
    And Validate "depositpaid" is "<depositpaid>"
    And Validate "checkin" is "<checkin>"
    And Validate "checkout" is "<checkout>"
    And Validate "additionalneeds" is "<additionalneeds>"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Ranjan   | 1101       | false       | 2025-03-03 | 2025-03-05 | Breakfast       |






