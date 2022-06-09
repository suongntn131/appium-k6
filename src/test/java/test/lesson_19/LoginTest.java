package test.lesson_19;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import test_flows.authentication.LoginFlow;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    public static void main(String[] args)  {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        Map<String, String> credData = new HashMap<>();
        credData.put("abc.defksdjkdjsf", "12345678");
        credData.put("test@sth.com", "1234567");
        credData.put("test@gmail.com", "12345678");
        try {
            for (String email : credData.keySet()) {
                LoginFlow loginFlow = new LoginFlow(appiumDriver, email, credData.get(email));
                loginFlow.goToLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
