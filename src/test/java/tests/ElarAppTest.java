package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class ElarAppTest extends TestBase {

    String username;
    String password;


    @DataProvider(name = "loginCredential")
    public static Object[][] loginCredential() {
        return new Object[][]{
                {ConfigReader.getProperty("ValidUsername"), ConfigReader.getProperty("ValidPassword"), "Success"},
                {"adskdjfskfjsfsd", "sdfsdkgfkrgrdh", "Error"},
                {ConfigReader.getProperty("ValidUsername"), "sdfsdkgfkrgrdh", "Error"},
                {"adskdjfskfjsfsd", ConfigReader.getProperty("ValidPassword"), "Error"}
        };
    }



    @Test(dataProvider = "loginCredential", groups = {"regression"})
    public void loginCredential(String username, String password, String statusMessage){
        this.username = username;
        this.password = password;
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        ElarAppLoginPage elarAppLogin = new ElarAppLoginPage();
        driver.navigate().refresh();
        elarAppLogin.userNameInput.sendKeys(username);
        elarAppLogin.passwordInput.sendKeys(password);
        elarAppLogin.loginButton.click();

        if(statusMessage.equals("Success")){
            Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Access denied!");
        }else if(statusMessage.equals("Error")){
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Invalid username or password']")).isDisplayed());
        }



    }

    }

