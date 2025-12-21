package testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstScript {

    @Test
    public void TC01_TestFirstScript() {
        String s1 = "Hello";
        String s2 = "Hello";

        Assert.assertEquals(s1, s2, "s1 is not s2 !");
    }
}
