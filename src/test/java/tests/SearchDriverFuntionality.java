package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElarAppDriversPage;
import pages.ElarAppNewDriverPage;
import utilities.ElarAppUtility;
import utilities.TestBase;

public class SearchDriverFuntionality extends TestBase {

    String driverId;

    @DataProvider(name = "SearchFunctionalityNamesTest")
    public Object[][] searchFunctionalityNamesTest() {
        return new Object[][]{
                {"John Lee", "john.lee@gmail.com"},
                {"Patel Doe", "patel.doe@gmail.com"},
                {"Alex Harsh", "alex.harsh@gmail.com"}
        };
    }
    @DataProvider(name = "SearchFunctionalityWithInvalidData")
    public Object[][] searchFunctionalityWithInvalidData() {
        return new Object[][]{
                {"John Bob", "@#$%^^&"}
        };
    }

    @Test(dataProvider = "SearchFunctionalityNamesTest", groups = {"regression"})
    public void searchDriverFunctionalityTest(String driverName,String driverEmail) throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
        searchDriver(driverName,driverEmail);
        elarAppDriversPage.searchBox.sendKeys(driverId + Keys.ENTER);
        Thread.sleep(2000);
        String actualDriverId = elarAppDriversPage.driverIDSearchResult.getText();
        String actualDriverName = elarAppDriversPage.driverNameSearchResult.getText();
        Assert.assertEquals(actualDriverId, driverId);
        Assert.assertEquals(actualDriverName, driverName);
    }

    @Test(dataProvider = "SearchFunctionalityNamesTest", groups = {"regression"})
    public void searchDriverFunctionalityByNameTest(String driverName,String driverEmail) throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
        Thread.sleep(2000);
        searchDriver(driverName,driverEmail);
        elarAppDriversPage.driverSearchByName.click();
        elarAppDriversPage.searchBox.sendKeys(driverName + Keys.ENTER);
        Thread.sleep(2000);
        for (WebElement element : elarAppDriversPage.resultNames) {
            Assert.assertTrue(element.getText().startsWith(driverName));
        }

    }
    @Test(dataProvider = "SearchFunctionalityNamesTest", groups = {"regression"})
    public void SearchFuntionalityWithEmailTest(String driverName,String driverEmail) throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
        Thread.sleep(2000);
        searchDriver(driverName,driverEmail);
        elarAppDriversPage.searchByEmail.click();
        elarAppDriversPage.searchBox.sendKeys(driverEmail + Keys.ENTER);
        Thread.sleep(2000);


    }
    @Test(dataProvider = "SearchFunctionalityWithInvalidData", groups = {"regression"})
    public void searchDriverWithInvalidEmail(String driverName, String driverInvalidEmail) throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
        searchDriver(driverName, driverInvalidEmail);

        Thread.sleep(2000);
        elarAppDriversPage.searchByEmail.click();
        elarAppDriversPage.searchBox.sendKeys(driverInvalidEmail + Keys.ENTER);
        Thread.sleep(2000);
        // UPDATED ASSERTION ONCE BUG IS FIXED
        Assert.fail();
    }

        public void searchDriver(String driverName,String driverEmail) throws InterruptedException {
            JavascriptExecutor jse = ((JavascriptExecutor) driver);
            ElarAppUtility elarAppUtility = new ElarAppUtility();
            elarAppUtility.addNewDriver();
            ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
            ElarAppDriversPage elarAppDriversPage = new ElarAppDriversPage();
            Thread.sleep(2000);

            elarAppNewDriverPage.addName.sendKeys(driverName);
            elarAppNewDriverPage.localBtn.click();
            elarAppNewDriverPage.localStateDropBox.click();
            elarAppNewDriverPage.georgiaState.click();
            elarAppNewDriverPage.addPhoneBtn1.click();
            elarAppNewDriverPage.inputPhone1.sendKeys("5127893654");

            Thread.sleep(1000);
            elarAppNewDriverPage.addEmailBtn1.click();
            if(!driverEmail.contains("@") || driverEmail.contains("$")){
                elarAppNewDriverPage.inputEmail1.sendKeys("john@gmail.com");
            }else elarAppNewDriverPage.inputEmail1.sendKeys(driverEmail);
            driverEmail=elarAppNewDriverPage.inputEmail1.getText();
            jse.executeScript("window.scrollBy(0, 500)");
            Thread.sleep(1000);
            elarAppNewDriverPage.drivingLcnInput.click();
            elarAppNewDriverPage.drivingLcnInput.sendKeys("04272025");
            elarAppNewDriverPage.medicalLcnInput.click();
            elarAppNewDriverPage.medicalLcnInput.sendKeys("04272025");
            jse.executeScript("window.scrollBy(0, 500)");
            elarAppNewDriverPage.twicCheckbox.click();
            elarAppNewDriverPage.createBtn.click();
            elarAppNewDriverPage.goToEditButton.click();
            jse.executeScript("window.scrollBy(0, 500)");
            driverId = elarAppNewDriverPage.driverId.getAttribute("value");
            jse.executeScript("window.scrollBy(0, -1400)");
            elarAppNewDriverPage.backToListButton.click();
            elarAppNewDriverPage.allDriversTabButton.click();
            Thread.sleep(1000);
            elarAppDriversPage.searchBox.click();
        }

}

