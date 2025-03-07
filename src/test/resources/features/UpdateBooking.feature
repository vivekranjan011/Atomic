@smoke
Feature: Update Booking for Heroku Booking Application


  Scenario Outline: Update Booking Info - Booking Id
    When Create Auth Token
    Then User re-enter details for booking
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | totalprice      | <totalprice>      |
      | depositpaid     | <depositpaid>     |
      | checkin         | <checkin>         |
      | checkout        | <checkout>        |
      | additionalneeds | <additionalneeds> |
    Then Perform update "booking" with "bookingid" request
    Then Validate 200 as the status Code
    And Extract below data from the response
      | firstname             | firstname   |
      | lastname              | lastname    |
      | depositpaid           | depositpaid |
      | totalprice            | totalproce  |
      | bookingdates.checkin  | checkin     |
      | bookingdates.checkout | checkout    |
    And Validate "firstname" is "<firstaname>"
    And Validate "totalprice" is 1101
    And Validate "checkin" is "2025-03-03"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Vivek     | Ranjan   | 1101       | false       | 2025-03-03 | 2025-03-05 | Breakfast       |


  Scenario Outline: Update few Booking Info - Booking Id
    When Create Auth Token
    Then User re-enter details for booking
      | totalprice      | <totalprice>             |
      | depositpaid     | <depositpaid>             |
      | checkin         | <checkin>       |
      | checkout        | <checkout>      |
      | additionalneeds | <additionalneeds> |
    Then Perform partial update "booking" with "bookingid" request
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
    And Validate "checkin" is "2025-03-04"

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Vivek     | Ranjan   | 1101       | false       | 2025-03-03 | 2025-03-05 | Breakfast, Lunch      |
