package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    /**
     * this class is inherited by all test classes.
     * it gives access to the driver, before method and after method.
     */

    @BeforeMethod(groups = {"regression"})
    public void setup(){
        driver = Driver.getDriver();
    }

    @AfterMethod(groups = {"regression"})
    public void teardown() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }

}
