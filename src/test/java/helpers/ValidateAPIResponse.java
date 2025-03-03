package helpers;

import net.serenitybdd.annotations.Step;
import org.junit.jupiter.api.Assertions;

import static helpers.Common.GLOBALMap;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidateAPIResponse extends ApiCalls{


    public void statusCode(int responseStatusCode){
        System.out.println("Message"+response.asPrettyString());
        response.then().assertThat().statusCode(responseStatusCode);
        assertEquals(responseStatusCode, response.statusCode());
    }

    @Step
    public void responseField(String key, String field){
        Assertions.assertEquals(GLOBALMap.get(key),field);
//        response.then().body(key,equalTo(field));
    }

    @Step
    public void responseField(String key, int field) {
        Assertions.assertEquals(GLOBALMap.get(key),field);
//        response.then().body(key, equalTo(field));
    }

    @Step
    public void responseField(String key, float field){
        Assertions.assertEquals(GLOBALMap.get(key),field);
//        response.then().body(key,equalTo(field));
    }

}


