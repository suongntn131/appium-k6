package test.lesson_18;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreen;

public class LoginScreenPOM_01 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            LoginScreen loginScreen = new LoginScreen(appiumDriver);
            // Click nav login
            loginScreen.bottomNavComponent().clickOnLoginIcon();

            // Fill login form
            loginScreen.loginFormComponent().inputEmail("test@gmail.com");
            loginScreen.loginFormComponent().inputPassword("12345678");
            loginScreen.loginFormComponent().clickOnLoginBtn();

            // Debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
