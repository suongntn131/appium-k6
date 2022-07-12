package learning.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;

public class ParameterTest {
    @Test
    @Parameters({"udid", "systemPort"})
    public void testTestNGParams(String udid, String systemPort) {
        System.out.println(new GregorianCalendar().getTime());
        System.out.println(udid + " || " + systemPort);
    }
}
