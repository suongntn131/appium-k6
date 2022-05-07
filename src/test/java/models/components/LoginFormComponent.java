package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> driver;

    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private MobileElement emailElem() {
        return driver.findElement(emailSel);
    }

    private MobileElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    private MobileElement loginBtnElem() {
        return driver.findElement(loginBtnSel);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailElem().sendKeys(email);
        }
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passwordElem().sendKeys(password);
        }
    }

    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }
}
