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

    @Test
    public void driverPaginationFunctionality() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
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
        elarAppDriversPage.fiveDriversButton.click();
        int expectedCount = 5; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount, "Mismatch in number of drivers displayed!");

       while(elarAppDriversPage.goToNextPage.getAttribute("tabIndex").equals("0")){

           elarAppDriversPage.goToNextPage.click();
           wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
           int expectedCount2 = 5; // Change this based on actual expectation
           Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount2, "Mismatch in number of drivers displayed!");
       }



    }

    @Test
    public void driverPaginationFunctionality2() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
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
        jse.executeScript("window.scrollBy(0, 15000)");
        jse.executeScript("window.scrollBy(0, 15000)");
        Thread.sleep(6000);
        elarAppDriversPage.rowsPerPage.click();
        elarAppDriversPage.tenDriversButton.click();
        int expectedCount = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));
        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount2 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount2, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount3 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount3, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount4 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount4, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount5 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount5, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount6 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount6, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount7 = 10; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount7, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }


    }

    @Test
    public void driverPaginationFunctionality3() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
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
        jse.executeScript("window.scrollBy(0, 600)");
        jse.executeScript("window.scrollBy(0, 300)");
        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(2000);
        elarAppDriversPage.rowsPerPage.click();
        elarAppDriversPage.twentyFiveButton.click();
        Thread.sleep(2000);
        int expectedCount = 25;
        jse.executeScript("arguments[0].scrollBy(0, 1300);", elarAppDriversPage.virtualScroller);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames2));
        Assert.assertEquals(elarAppDriversPage.resultNames2.size(), expectedCount, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames2.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames2.get(i));
        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames2));
        int expectedCount2 = 25; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames2.size(), expectedCount2, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames2.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames2.get(i));

        }
        elarAppDriversPage.goToNextPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(elarAppDriversPage.resultNames));
        int expectedCount3 = 25; // Change this based on actual expectation
        Assert.assertEquals(elarAppDriversPage.resultNames.size(), expectedCount3, "Mismatch in number of drivers displayed!");

        for (int i = 0; i < elarAppDriversPage.resultNames.size(); i++) {
            System.out.println(elarAppDriversPage.resultNames.get(i));

        }
    }
}
