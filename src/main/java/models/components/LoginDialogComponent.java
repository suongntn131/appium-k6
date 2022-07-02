package models.components;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDialogComponent {

    private final AppiumDriver<MobileElement> driver;

    private final static By okBtnSel = MobileBy.id("android:id/button1");

    public LoginDialogComponent(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void clickOnOkBtn() {
        driver.findElement(okBtnSel).click();
    }


}
