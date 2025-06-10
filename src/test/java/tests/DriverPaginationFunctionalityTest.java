package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElarAppDriversPage;
import pages.ElarAppLoginPage;
import pages.NewLocationPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.time.Duration;

public class DriverPaginationFunctionalityTest extends TestBase {

    @DataProvider(name = "paginationTest")
    public Object[][] paginationTestData(){
        return new Object[][]{
                {5},
                {10}
        };
    }

    @Test(dataProvider = "paginationTest", groups = {"regression"})
    public void driverPaginationFunctionality(int numberPerPage) throws InterruptedException {

        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("ElarAppURL"));
        ElarAppLoginPage elarAppLoginPage = new ElarAppLoginPage();
        elarAppLoginPage.userNameInput.sendKeys(ConfigReader.getProperty("ValidUsername"));
        elarAppLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("ValidPassword"));
        elarAppLoginPage.loginButton.click();
        NewLocationPage newLocationPage = new NewLocationPage();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(newLocationPage.driverBtn));
        newLocationPage.driverBtn.click();
        ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
        Actions actions=new Actions(driver);
        actions.moveToElement(elarAppDriversPage.virtualScroller).sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(6000);
        elarAppDriversPage.rowsPerPage.click();
        int expectedCount=0;
        if(numberPerPage==5){
            elarAppDriversPage.fiveDriversButton.click();
            expectedCount = 5; // Change this based on actual expectation
        }else if(numberPerPage==10){
            elarAppDriversPage.tenDriversButton.click();
            expectedCount = 10; // Change this based on actual expectation
        }

        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount, "Mismatch in number of drivers displayed!");

       while(elarAppDriversPage.goToNextPage.getAttribute("tabIndex").equals("0")){

           elarAppDriversPage.goToNextPage.click();
           wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));

           Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount, "Mismatch in number of drivers displayed!");
       }



    }
}
