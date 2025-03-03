package helpers;

import net.serenitybdd.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class Common extends ApiCalls {
    public static Map<String, Object> GLOBALMap = new HashMap<>();

    @Step
    public void getField(String path, String key){
        GLOBALMap.put(key,response.getBody().path(path));
    }
}
