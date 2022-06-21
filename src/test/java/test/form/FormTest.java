package test.form;

import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.form.FormFlow;

public class FormTest extends BaseTest {

    @Test
    public void testFormInput() {
        FormFlow formFlow = new FormFlow(appiumDriver);
        formFlow.goToFormScreen();
        formFlow.fillTheForm();
        formFlow.verifyFormDisplay();
    }
}
