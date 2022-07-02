package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    private AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver<MobileElement> getDriver(Platforms platform){
        if (platform == null){
            throw new IllegalArgumentException("Platform cannot  be null, pls provide one of these: " + Arrays.toString(Platforms.values()));
        }

        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
            desiredCapabilities.setCapability(UDID,"R58M45PFJZW");
            desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
            desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");

            // Init appium session
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            switch (platform){
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer,desiredCapabilities);
                    break;
                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer,desiredCapabilities);
                    break;
            }
        } catch (Exception e){
            exception = e;
        }

        if (appiumDriver == null){
            throw new RuntimeException(exception.getMessage());
        }

        appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        return  appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platforms platform, String uuid, String systemPort, String platformVersion){
        if (appiumDriver == null) {
            if (platform == null){
                throw new IllegalArgumentException("Platform cannot  be null, pls provide one of these: " + Arrays.toString(Platforms.values()));
            }

            Exception exception = null;
            try {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(PLATFORM_NAME,platform);

                // Init appium session
//                URL appiumServer = new URL("http://localhost:4723/wd/hub");
                URL targetServer = new URL("http://192.168.1.46:4444/wd/hub");

                switch (platform){
                    case android:
                        desiredCapabilities.setCapability(AUTOMATION_NAME,"uiautomator2");
                        desiredCapabilities.setCapability(UDID,uuid);
                        desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
                        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
                        desiredCapabilities.setCapability(SYSTEM_PORT,Integer.parseInt(systemPort));
                        appiumDriver = new AndroidDriver<>(targetServer,desiredCapabilities);
                        break;
                    case ios:
                        desiredCapabilities.setCapability(AUTOMATION_NAME,"XCUITest");
                        desiredCapabilities.setCapability(DEVICE_NAME,uuid);
                        desiredCapabilities.setCapability(PLATFORM_VERSION,platformVersion); // 15.1 not 15.1.2
                        desiredCapabilities.setCapability(BUNDLE_ID,"org.wdiNativeApp");
                        desiredCapabilities.setCapability(WDA_LOCAL_PORT,Integer.parseInt(systemPort));
                        appiumDriver = new IOSDriver<>(targetServer,desiredCapabilities);
                        break;
                }
            } catch (Exception e){
                exception = e;
            }

            if (appiumDriver == null){
                throw new RuntimeException(exception.getMessage());
            }

            appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        }
        return  appiumDriver;
    }

    public void quitAppiumDriver(){
        if (appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

}
