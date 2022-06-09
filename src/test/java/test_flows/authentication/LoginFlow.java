package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.LoginFormComponent;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private final AppiumDriver<MobileElement> appiumDriver;
    private String emailStr;
    private String passwordStr;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String emailStr, String passwordStr) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.emailStr = emailStr;
        this.passwordStr = passwordStr;
    }

    public void login() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormCom = loginScreen.loginFormComponent();
        if (!emailStr.isEmpty()) {
            MobileElement emailElem = loginFormCom.emailElem();
            emailElem.clear();
            emailElem.sendKeys(emailStr);
        }

        if (!passwordStr.isEmpty()) {
            MobileElement passwordElem = loginFormCom.passwordElem();
            passwordElem.clear();
            passwordElem.sendKeys(passwordStr);
        }

        loginFormCom.clickOnLoginBtn();
    }

    public void verifyLogin() {
        boolean isEmailValid = EmailValidator.getInstance().isValid(emailStr);
        boolean isPasswordValid = passwordStr.length() >= 8;

        System.out.printf("Email: %s, %b | Password: %s, %b\n", emailStr, isEmailValid, passwordStr, isPasswordValid);

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComponent loginFormCom = loginScreen.loginFormComponent();

        if (isEmailValid && isPasswordValid) {
            verifyCorrectLoginCreds(loginFormCom);
        }

        if (!isEmailValid) {
            verifyIncorrectEmailStr(loginFormCom);
        }

        if (!isPasswordValid) {
            verifyIncorrectPasswordStr(loginFormCom);
        }
    }

    private void verifyCorrectLoginCreds(LoginFormComponent loginFormCom) {
        String actualLoginSuccessMesStr = loginFormCom.getLoginSuccessMesStr();
        String expectedLoginSuccessMesStr = "You are logged in!";

        // Verification
        System.out.println("actualLoginSuccessMesStr: " + actualLoginSuccessMesStr);
        System.out.println("expectedLoginSuccessMesStr: " + expectedLoginSuccessMesStr);
        MobileElement btnOK = appiumDriver.findElement(MobileBy.id("android:id/button1"));
        btnOK.click();
    }

    private void verifyIncorrectEmailStr(LoginFormComponent loginFormCom) {
        String actualInvalidEmailStr = loginFormCom.getInvalidEmailStr();
        String expectedInvalidEmailStr = "Please enter a valid email address";

        // Verification
        System.out.println("actualInvalidEmailStr: " + actualInvalidEmailStr);
        System.out.println("expectedInvalidEmailStr: " + expectedInvalidEmailStr);
    }

    private void verifyIncorrectPasswordStr(LoginFormComponent loginFormCom) {
        String actualInvalidPasswordStr = loginFormCom.getInvalidPasswordStr();
        String expectedInvalidPasswordStr = "Please enter at least 8 characters";

        // Verification
        System.out.println("actualInvalidPasswordStr: " + actualInvalidPasswordStr);
        System.out.println("expectedInvalidPasswordStr: " + expectedInvalidPasswordStr);
    }
}