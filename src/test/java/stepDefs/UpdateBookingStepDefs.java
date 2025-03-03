package stepDefs;

import helpers.ApiCalls;
import helpers.Common;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import java.util.HashMap;
import java.util.Map;

import static helpers.Common.GLOBALMap;

public class UpdateBookingStepDefs {
    @Shared
    ApiCalls apiCalls;

    @Shared
    Common common;

    @When("User re-enter details for booking")
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
        apiCalls.setBody(jsonMap);
    }

    @Given("Perform update {string} with {string} request")
    public void perform_put_call_with_param(String resource,String param){
        resource = resource.concat("/"+GLOBALMap.get(param));
        apiCalls.put(resource);
    }

    @Given("Perform partial update {string} with {string} request")
    public void perform_patch_call_with_param(String resource,String param){
        resource = resource.concat("/"+GLOBALMap.get(param));
        apiCalls.patch(resource);
    }
}
