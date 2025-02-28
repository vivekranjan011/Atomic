package stepDefs;

import helpers.ApiCalls;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Shared;

import java.util.HashMap;
import java.util.Map;

public class BookingStepDefs {
    public static
    @Shared
    ApiCalls apiCalls;

    @Given("User Enter details for booking")
    public void i_create_new_booking_with_following_data(DataTable dataTable) {
        Map<String, String> bookingData = dataTable.asMap(String.class, String.class);
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("firstname", bookingData.get("firstname"));
        jsonMap.put("lastname", bookingData.get("lastname"));
        jsonMap.put("totalprice", Integer.parseInt(bookingData.get("totalprice")));
        jsonMap.put("depositpaid", Boolean.parseBoolean(bookingData.get("depositpaid")));
        jsonMap.put("additionalneeds", bookingData.get("additionalneeds"));

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", bookingData.get("checkin"));
        bookingDates.put("checkout", bookingData.get("checkout"));
        jsonMap.put("bookingdates", bookingDates);
        apiCalls.setBody(jsonMap.toString());
    }

    @Then("Perform post {string} request")
    public void perform_post_call(String resource){
        apiCalls.post(resource);
    }
    }