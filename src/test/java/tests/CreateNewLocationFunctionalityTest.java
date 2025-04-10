package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.NewLocationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class CreateNewLocationFunctionalityTest extends TestBase {

    @Test
    public void createNewLocationFunctionality() throws InterruptedException {
        driver= Driver.getDriver();
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        ElarAppLoginPage elarAppLoginPage = new ElarAppLoginPage();
        elarAppLoginPage.userNameInput.sendKeys(ConfigReader.getProperty("ValidUsername"));
        elarAppLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("ValidPassword"));
        elarAppLoginPage.loginButton.click();
        NewLocationPage newLocationPage = new NewLocationPage();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.driverBtn));
        newLocationPage.driverBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.addDriver));
        Thread.sleep(3000);
        newLocationPage.addDriver.click();
        newLocationPage.searchBtn.click();
        Assert.assertEquals(newLocationPage.addressInput.getText(), "Address");
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.createNew));
        newLocationPage.createNew.click();
        wait.until(ExpectedConditions.visibilityOf(newLocationPage.nameHeader));
        newLocationPage.nameHeader.sendKeys("Home Address");
    }
}
