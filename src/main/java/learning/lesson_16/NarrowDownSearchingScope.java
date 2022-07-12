package learning.lesson_16;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NarrowDownSearchingScope {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver(Platforms.android);

        try {
            // Get screen size
            Dimension windowSize = driver.manage().window().getSize();
            int screenHeight = windowSize.height;
            int screenWidth = windowSize.width;

            // Calculate
            int xStartPoint = 40 * screenWidth / 100;
            int xEndPoint = 40 * screenWidth / 100;

            int yStartPoint = 0;
            int yEndPoint = 90 * screenHeight / 100;

            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            TouchAction touchAction = new TouchAction(driver);
            touchAction
                    .press(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            Map<String, String> notifications = new HashMap();
            List<MobileElement> notiElems = driver.findElements(MobileBy.id("android:id/notification_main_column"));
            for (MobileElement notiElem : notiElems) {
                try {
                MobileElement titleElem = notiElem.findElement(MobileBy.id("android:id/title"));
                String titleText = titleElem.getText();

                    MobileElement contentElem = notiElem.findElement(MobileBy.id("android:id/text"));


                    String contentText = contentElem.getText();

                    notifications.put(titleText, contentText);
                } catch (Exception e) {

                }
            }
            if (notifications.keySet().isEmpty()) {
                throw new RuntimeException("[ERR] There is no notification to test");
            } else {
                for (String title : notifications.keySet()) {
                    System.out.println("Title: " + title);
                    System.out.println("Content: " + notifications.get(title));
                }
            }

            touchAction
                    .longPress(endPoint)
                    .moveTo(startPoint)
                    .release()
                    .perform();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
