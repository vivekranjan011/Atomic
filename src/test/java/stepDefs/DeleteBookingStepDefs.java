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

public class DeleteBookingStepDefs {
    @Shared
    ApiCalls apiCalls;

    @Given("Perform delete {string} with {string} request")
    public void perform_put_call_with_param(String resource,String param){
        resource = resource.concat("/"+GLOBALMap.get(param));
        apiCalls.delete(resource);
    }

}
