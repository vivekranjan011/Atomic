package helpers;

import com.google.gson.Gson;
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
    public static Response response = null;

    @Step
    public void post(String resource){
        System.out.println(jsonRequestBody);
         response = SerenityRest.given(requestSpecification)
                .body(jsonRequestBody)
                .when()
                .post("/"+ resource)
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
    }

    @Step
    public void get(String resource){
         response = SerenityRest.given(requestSpecification)
                .when()
                .get("/"+resource)
                .then().extract().response();
        System.out.println(SerenityRest.lastResponse());
    }

    @Step
    public void setBody(Object body){
        Gson gson = new Gson();
        jsonRequestBody = gson.toJson(body);
        System.out.println(jsonRequestBody);
    }



}
