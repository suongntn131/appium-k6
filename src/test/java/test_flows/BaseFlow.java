package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.HomeScreen;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToLoginScreen(){
        new HomeScreen(appiumDriver).bottomNavComponent().clickOnLoginIcon();
    }

    public void goToFormScreen(){
        new HomeScreen(appiumDriver).bottomNavComponent().clickOnFormsIcon();
    }
}
