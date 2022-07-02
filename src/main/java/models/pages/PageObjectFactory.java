package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageObjectFactory {
    private final AppiumDriver<MobileElement> appiumDriver;

    public PageObjectFactory(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(5)),this);
    }

    @AndroidFindBy(accessibility = "input-email")
    private MobileElement emailElem;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private MobileElement passwordElem;

    @AndroidFindBy(accessibility = "input-email")
    private MobileElement loginBtnElem;

    public void inputEmail(String email){
        if (!email.isEmpty()){
            emailElem.sendKeys(email);
        }
    }

    public void inputPassword(String password){
        if (!password.isEmpty()){
            passwordElem.sendKeys(password);
        }
    }

    public void clickOnLoginBtn(){
        loginBtnElem.click();
    }
}
