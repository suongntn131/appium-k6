package test.authen;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCredData loginCredData) {
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginCredData.getEmail(), loginCredData.getPassword());
        loginFlow.goToLoginScreen();
        loginFlow.login();
        loginFlow.verifyLogin();
    }

    @DataProvider
    public LoginCredData[] loginCredData() {
        String filePath = "/src/main/java/test_data/authen/LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);
    }
}
