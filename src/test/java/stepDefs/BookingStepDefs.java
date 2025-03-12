package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import helpers.ApiCalls;
import helpers.Common;
import helpers.JacksonLibs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.BookingDatesDTO;
import model.DetailsDTO;
import net.serenitybdd.annotations.Shared;

import java.util.HashMap;
import java.util.Map;

public class BookingStepDefs {
    public static
    @Shared
    ApiCalls apiCalls;

    @Shared
    DetailsDTO bookingDTO;

    @Shared
    JacksonLibs jacksonLibs;

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
        apiCalls.setBody(jsonMap);
    }

    @Given("User Enter details for booking payload")
    public void i_create_new_booking_with_following_data_for_payload(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> bookingData = dataTable.asMap(String.class, String.class);
        Map<String, Object> jsonMap = new HashMap<>();
        BookingDatesDTO bookingDates = new BookingDatesDTO(bookingData.get("checkin"), bookingData.get("checkout"));
                bookingDTO = new DetailsDTO(bookingData.get("firstname"),bookingData.get("lastname"),
                Integer.parseInt(bookingData.get("totalprice")),Boolean.parseBoolean(bookingData.get("depositpaid")),
                bookingData.get("additionalneeds"), bookingDates);
        String body = jacksonLibs.bodyAsJsonString(bookingDTO);
        apiCalls.setBody(body);
    }

    @Then("Perform post {string} request")
    public void perform_post_call(String resource){
        apiCalls.post(resource);
    }


    }