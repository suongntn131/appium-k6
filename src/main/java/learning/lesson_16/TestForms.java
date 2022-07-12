package learning.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestForms {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement navFormsElem = driver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsElem.click();
            MobileElement txtInputElem = driver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement switchElem = driver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement dropdownElem = driver.findElement(MobileBy.AccessibilityId("Dropdown"));
            MobileElement btnActive = driver.findElement(MobileBy.AccessibilityId("button-Active"));
            txtInputElem.sendKeys("Hello");
            switchElem.click();
            dropdownElem.click();
            List<MobileElement> lvElems = driver.findElements(MobileBy.id("android:id/text1"));
            lvElems.get(2).click();
            btnActive.click();
            WebDriverWait wait = new WebDriverWait(driver,5L);
            MobileElement btnOK = driver.findElement(MobileBy.id("android:id/button1"));
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
