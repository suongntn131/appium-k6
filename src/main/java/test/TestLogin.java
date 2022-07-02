package test;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click nav login
            MobileElement navLoginBtnElem = driver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill login form
            MobileElement txtUsernameElem = driver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement txtPasswordElem = driver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement btnLoginElem = driver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            txtUsernameElem.sendKeys("test@gmail.com");
            txtPasswordElem.sendKeys("12345678");
            btnLoginElem.click();

            WebDriverWait wait = new WebDriverWait(driver,5L);
            WebElement loginMessageElem = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/message")));
            System.out.println("Result: " + loginMessageElem.getText());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
