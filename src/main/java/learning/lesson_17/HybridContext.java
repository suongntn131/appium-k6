package learning.lesson_17;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);
        try {
            // Navigate to webview screen
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnElem = driver.findElement(webviewNavBtnSel);
            webviewNavBtnElem.click();

            // Wait until we have more than 1 context
            WebDriverWait wait = new WebDriverWait(driver, 15L);
            wait.until(new WaitMoreThanOneContext(driver));

            // Get all context names
            driver.getContextHandles().forEach(context -> {
                System.out.println(context);
            });

            // Switch to webview context
            driver.context(Contexts.WEB_VIEW);

            // Interact on webview elements
            WebElement navToggleBtnElem = driver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnElem.click();

            List<MobileElement> menuItemElems = driver.findElements(By.cssSelector(".menu__list li a"));
            List<MenuItemData> menuItemDataList = new ArrayList<>();
            if (menuItemElems.isEmpty()){
                throw new RuntimeException("[ERR] There is no list item!");
            }

            for (MobileElement menuItemElem : menuItemElems) {
                String itemText = menuItemElem.getText();
                String itemHref = menuItemElem.getAttribute("href");
                if (itemText.isEmpty())
                    menuItemDataList.add(new MenuItemData("Github", itemHref));
                else
                    menuItemDataList.add(new MenuItemData(itemText,itemHref));
            }

            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println(menuItemData.getName());
                System.out.println(menuItemData.getHref());
            }

            // Switch back to NATIVE context
            driver.context(Contexts.NATIVE);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static class MenuItemData{
        private String name;
        private String href;

        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        public String getName() {
            return name;
        }

        public String getHref() {
            return href;
        }
    }
}
