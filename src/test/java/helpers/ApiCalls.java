package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.Optional;

public class ApiCalls {

    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(BASE_URI).setContentType(ContentType.JSON).build();
    private static String jsonRequestBody = null;

    @Step
    public void post(String resource){
        System.out.println(jsonRequestBody);
        SerenityRest.given(requestSpecification)
                .body(jsonRequestBody)
                .when()
                .post("/"+ resource)
                .then()
                .extract().response();
        System.out.println("============================");

        System.out.println(SerenityRest.lastResponse().body().asString());
    }

    @Step
    public void get(String resource){
        Response response = SerenityRest.given(requestSpecification)
                .when()
                .get("/"+resource)
                .then().extract().response();
        System.out.println(SerenityRest.lastResponse());
    }

    @Step
    public void setBody(String body){
        jsonRequestBody = body;
    }


}
