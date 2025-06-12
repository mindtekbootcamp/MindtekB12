package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;


public class ShowPasswordFunctionality extends TestBase {
        WebDriver driver;

        @Test(groups = {"regression"})
        public void showPasswordFunctionality() {
            driver = Driver.getDriver();
            driver.get(ConfigReader.getProperty("ElarAppURL"));
            ElarAppLoginPage elarAppLoginPage = new ElarAppLoginPage();
            elarAppLoginPage.userNameInput.sendKeys(ConfigReader.getProperty("ValidUsername"));
            elarAppLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("ValidPassword"));
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Assert.assertTrue(driver.findElement(By.id("login-password")).isDisplayed(), "collaboration900");
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='●●●●●●']")).isDisplayed(), "●●●●●●");


        }
    }

