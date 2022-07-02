package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormComponent {

    private final AppiumDriver<MobileElement> driver;

    private final static By emailSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTxtSel = MobileBy.xpath("//*[contains(@text, 'Please enter a valid email address')]");
    private final static By passwordSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPasswordTxtSel = MobileBy.xpath("//*[contains(@text, 'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    private final static By loginSuccessMesSel = MobileBy.id("android:id/message");

    public LoginFormComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement emailElem() {
        return driver.findElement(emailSel);
    }

    public MobileElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    public MobileElement loginBtnElem() {
        return driver.findElement(loginBtnSel);
    }

    public void inputEmail(String email) {
        if (!email.isEmpty()) {
            emailElem().sendKeys(email);
        }
    }

    public String getInvalidEmailStr(){
        return driver.findElement(incorrectEmailTxtSel).getText().trim();
    }

    public void inputPassword(String password) {
        if (!password.isEmpty()) {
            passwordElem().sendKeys(password);
        }
    }

    public String getInvalidPasswordStr(){
        return driver.findElement(incorrectPasswordTxtSel).getText().trim();
    }

    public void clickOnLoginBtn() {
        loginBtnElem().click();
    }

    public String getLoginSuccessMesStr(){
        WebDriverWait wait = new WebDriverWait(driver,5L);
        WebElement loginMessageElem = wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessMesSel));
        return loginMessageElem.getText().trim();
    }
}
