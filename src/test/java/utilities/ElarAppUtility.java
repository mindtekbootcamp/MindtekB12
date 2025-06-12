package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ElarAppLoginPage;
import pages.ElarAppNewDriverPage;


public class ElarAppUtility extends TestBase {

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



}
