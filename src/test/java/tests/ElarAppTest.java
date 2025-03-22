package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.elarAppLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class ElarAppTest extends TestBase {

    @Test
    public void loginPositive(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        elarAppLoginPage elarAppLogin = new elarAppLoginPage();
        elarAppLogin.elarAppLoginPage("ValidUsername", "ValidPassword");
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Access denied!");
    }
    @Test
    public void loginNegative(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        elarAppLoginPage elarAppLogin = new elarAppLoginPage();
        elarAppLogin.elarAppLoginPage("InvalidUsername","InvalidPassword");
        Assert.assertEquals(driver.findElement(By.tagName("h5")).getText(),"Login");
    }
    @Test
    public void loginPositiveUsername(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        elarAppLoginPage elarAppLogin = new elarAppLoginPage();
        elarAppLogin.elarAppLoginPage("ValidUsername", "InvalidPassword");
        Assert.assertEquals(driver.findElement(By.tagName("h5")).getText(),"Login");
    }
    @Test
    public void loginNegativeUsername(){
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        elarAppLoginPage elarAppLogin = new elarAppLoginPage();
        elarAppLogin.elarAppLoginPage("InvalidUsername", "ValidPassword");
        Assert.assertEquals(driver.findElement(By.tagName("h5")).getText(),"Login");

    }

}
