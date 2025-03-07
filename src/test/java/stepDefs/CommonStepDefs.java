package stepDefs;

import helpers.ApiCalls;
import helpers.Common;
import helpers.ValidateAPIResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import java.util.List;
import java.util.Map;

import static helpers.Common.GLOBALMap;

public class CommonStepDefs {
    @Shared
    ValidateAPIResponse validateResponse;


    @Shared
    Common common;

    @Then("Validate {int} as the status Code")
    public void i_validate_status_code(int statusCode) {
        validateResponse.statusCode(statusCode);
    }

    @And("Get from response path {string} store in {string}")
    public void get_field_from_response(String path, String key){
        common.getField(path, key);
    }

    @And("Validate {string} is {string}")
    public void validate_text_field_from_response(String key, String value){
        validateResponse.responseField(key, value);
    }


    @And("Validate {string} is {int}")
    public void validate_int_field_from_response(String key, int value){
        validateResponse.responseField(key, value);
    }

    @And("Validate {string} is {boolean}")
    public void validate_boolean_field_from_response(String key, boolean value) {
        validateResponse.responseField(key, value);
    }

    @When("Create Auth Token")
    public void create_auth_token(){
        common.createAuthToken();
    }

    @And("Extract below data from the response")
    public void extract_response_and_store(DataTable dataTable){
        common.storeValue(dataTable);
    }
}
