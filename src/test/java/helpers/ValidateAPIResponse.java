package helpers;

import net.serenitybdd.annotations.Step;
import org.junit.jupiter.api.Assertions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static helpers.Common.GLOBALMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


//hamcrest


public class ValidateAPIResponse extends ApiCalls{


    public void statusCode(int responseStatusCode){
        assertThat("Status Code not matched", response.statusCode(), equalTo(responseStatusCode));
    }

    @Step
    public void responseField(String key, String field){
        assertThat("Value from GLOBALMap text does not match expected", GLOBALMap.get(key), Matchers.equalTo(field));
    }

    @Step
    public void responseField(String key, int field) {
        assertThat("Value from GLOBALMap number does not match expected", GLOBALMap.get(key), Matchers.equalTo(field));
    }

    @Step
    public void responseField(String key, float field){
        assertThat("Value from GLOBALMap Decimal number does not match expected", GLOBALMap.get(key), Matchers.equalTo(field));
    }

    @Step
    public void responseField(String key, boolean field){
        assertThat("Value from GLOBALMap Decimal number does not match expected", GLOBALMap.get(key), Matchers.equalTo(field));
    }

}


