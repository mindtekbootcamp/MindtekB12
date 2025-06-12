package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.NewLocationPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class CreateNewLocationFunctionalityTest extends TestBase {

    @Test(groups = {"regression"})
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
        //Assert.assertEquals(newLocationPage.addressInput.getText(), "Address");
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.createNew));
        newLocationPage.createNew.click();
//        wait.until(ExpectedConditions.visibilityOf(newLocationPage.nameHeader));
        newLocationPage.nameHeader.sendKeys("Mauricio Correa");
        String address=BrowserUtils.randomAddressGenerator();
        newLocationPage.addressInput.sendKeys(address);
        newLocationPage.cityInput.sendKeys("Houston");
        newLocationPage.stateInput.click();
        Thread.sleep(3000);
        newLocationPage.texasBtn.click();
        newLocationPage.zipcodeInput.sendKeys("77498");
        newLocationPage.aptSuite.sendKeys("23");
        newLocationPage.createBtn.click();
        Thread.sleep(4000);
        newLocationPage.deleteBtn.click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.searchBtn));
        Thread.sleep(5000);
        newLocationPage.searchBtn.click();
        Thread.sleep(4000);
        
        newLocationPage.addressInput2.sendKeys(address);
        Thread.sleep(2000);
        newLocationPage.searchBtn2.click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+address+" Houston TX 77498 23']")).isDisplayed());

    }

}


//mauricio number 1
//nelson
