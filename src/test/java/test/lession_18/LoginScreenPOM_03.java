package test.lession_18;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.LoginFormComponent;
import models.pages.LoginScreen;

public class LoginScreenPOM_03 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);

            // Click nav login
            loginScreen.bottomNavComponent().clickOnLoginIcon();

            // Fill login form
            LoginFormComponent loginFormComponent = loginScreen.loginFormComponent();
            loginFormComponent.inputEmail("test@gmail.com");
            loginFormComponent.inputPassword("12345678");
            loginFormComponent.clickOnLoginBtn();

            // Debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
