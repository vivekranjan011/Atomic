package helpers;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Common extends ApiCalls {
    public static Map<String, Object> GLOBALMap = new HashMap<>();
    public static String USERNAME = "admin";
    public static String PASSWORD = "password123";
    public Map<String, Object> jsonMap = new HashMap<>();


    @Step
    public void getField(String path, String key){
        GLOBALMap.put(key,response.getBody().path(path));
    }

    @Step
    public void authBody(){
        jsonMap.put("username",USERNAME);
        jsonMap.put("password",PASSWORD);
        setBody(jsonMap);
    }

    @Step
    public void createAuthToken(){
        authBody();
        post("auth");
        GLOBALMap.put("token",response.getBody().path("token"));
    }

    @Step
    public void storeValue(DataTable dataTable){
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        for(Map<String, String>list : table){
            GLOBALMap.put(list.get("field"),list.get("key"));
        }
    }
}
