package stepDefs;

import helpers.ApiCalls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Shared;

import static helpers.Common.GLOBALMap;

public class GetBookingsStepDefs {
    @Shared
    ApiCalls apiCalls;

    @Given("Perform get {string} request")
    public void perform_get_call(String resource){
        apiCalls.get(resource);
    }

    @Given("Perform get {string} with {string} request")
    public void perform_get_call_with_param(String resource,String param){
        resource = resource.concat("/"+GLOBALMap.get(param));
        apiCalls.get(resource);
    }

}
