package test.lesson_18;

import driver.AppPackages;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class HandleMultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        try {
            // Login then input credentials > click on Login btn

            // Click nav login
            MobileElement navLoginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Fill login form
            MobileElement txtUsernameElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement txtPasswordElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement btnLoginElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            txtUsernameElem.sendKeys("test@gmail.com");
            txtPasswordElem.sendKeys("12345678");
            btnLoginElem.click();

            // Put the app into background
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Turn wifi off

            appiumDriver.activateApp(AppPackages.settings);

            By connectionsLabelSel = MobileBy.xpath("//*[@text='Connections']");
            By wifiStatusSel = MobileBy.AccessibilityId("Wi-Fi");

            // Navigate to wifi list
            MobileElement connectionsLabelElem  = appiumDriver.findElement(connectionsLabelSel);
            connectionsLabelElem.click();

            // Trigger on/off wifi logic
            MobileElement wifiStatusElem = appiumDriver.findElement(wifiStatusSel);
            String wifiStatusStr = wifiStatusElem.getText().trim();

            boolean isWifiOn = wifiStatusStr.equalsIgnoreCase("on");
            if (isWifiOn){
                wifiStatusElem.click();
            }

            // Comeback to the app > interact with other elements
            appiumDriver.activateApp(AppPackages.wdio);
            appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']")).click();

            // Debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
