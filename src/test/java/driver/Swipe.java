package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Swipe{
    public static void swipeUp(AppiumDriver driver, Dimension windowSize){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 40 * screenWidth / 100;
        int xEndPoint = 40 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 0;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeUp(AppiumDriver driver, Dimension windowSize, int percentage){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 40 * screenWidth / 100;
        int xEndPoint = 40 * screenWidth / 100;

        int yStartPoint = percentage * screenHeight / 100;
        int yEndPoint = 0;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeDown(AppiumDriver driver, Dimension windowSize){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 40 * screenWidth / 100;
        int xEndPoint = 40 * screenWidth / 100;

        int yStartPoint = 0;
        int yEndPoint = 50 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeDown(AppiumDriver driver, Dimension windowSize, int percentage){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 40 * screenWidth / 100;
        int xEndPoint = 40 * screenWidth / 100;

        int yStartPoint = 0;
        int yEndPoint = percentage * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeLeftToRight(AppiumDriver driver, Dimension windowSize){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 90 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 50 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeLeftToRight(AppiumDriver driver, Dimension windowSize, int percentage){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = percentage * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 50 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeRightToLeft(AppiumDriver driver, Dimension windowSize){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 50 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void swipeRightToLeft(AppiumDriver driver, Dimension windowSize, int percentage){
        int screenHeight = windowSize.height;
        int screenWidth = windowSize.width;

        // Calculate
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = percentage * screenWidth / 100;

        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = 50 * screenHeight / 100;

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }
}