package test.lesson_20;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import test_data.models.LoginCredData;

public class TestGSON {
    public static void main(String[] args) {
        // Convert from Object -> JSON
        LoginCredData loginCredData = new LoginCredData("test@sth.com", "12345678");
        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCredData));

        // Convert from JSON -> Object
        String loginCredJSONData = "{\"email\":\"test@sth.com\",\"password\":\"12345678\"}";
        LoginCredData convertedFromJson = gson.fromJson(loginCredJSONData, LoginCredData.class);
        System.out.println(convertedFromJson);
    }
}
