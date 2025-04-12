package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.ElarAppNewDriverPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class newDriverTest {
    WebDriver driver;
    String abs ="Hi";


    public void addNewDriver(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        ElarAppLoginPage elarAppLoginPage = new ElarAppLoginPage();
        elarAppLoginPage.userNameInput.sendKeys(ConfigReader.getProperty("ValidUsername"));
        elarAppLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("ValidPassword"));
        elarAppLoginPage.loginButton.click();

        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        elarAppNewDriverPage.driverPage.click();
        elarAppNewDriverPage.addNewDriverButton.click();
    }

    @Test
    public void positiveCredentials (){
        addNewDriver();

        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();

        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("John Doe");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        elarAppNewDriverPage.georgiaState.click();


    }
}
