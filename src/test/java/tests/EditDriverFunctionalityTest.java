package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElarAppDriversPage;
import pages.ElarAppNewDriverPage;
import utilities.ElarAppUtility;
import utilities.TestBase;
import java.util.List;

public class EditDriverFunctionalityTest extends TestBase {


     public void createDriver() throws InterruptedException {
         JavascriptExecutor jse = ((JavascriptExecutor) driver);
         ElarAppUtility elarAppUtility=new ElarAppUtility();
         elarAppUtility.addNewDriver();

         ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
         elarAppNewDriverPage.stuffBtn.click();
         elarAppNewDriverPage.addName.sendKeys("John Doe");
         elarAppNewDriverPage.localBtn.click();
         elarAppNewDriverPage.localStateDropBox.click();
         Thread.sleep(1000);
         jse.executeScript("window.scrollBy(0, 1000)");
         elarAppNewDriverPage.newYorkState.click();
         elarAppNewDriverPage.addPhoneBtn1.click();
         elarAppNewDriverPage.inputPhone1.sendKeys("2345678900");
         jse.executeScript("window.scrollBy(0, 200)");
         jse.executeScript("window.scrollBy(0, 200)");
         elarAppNewDriverPage.drivingLcnInput.click();
         elarAppNewDriverPage.drivingLcnInput.sendKeys("06012025");
         elarAppNewDriverPage.medicalLcnInput.click();
         elarAppNewDriverPage.medicalLcnInput.sendKeys("06012025");
         jse.executeScript("window.scrollBy(0, 500)");
         elarAppNewDriverPage.createBtn.click();
         Thread.sleep(1000);
     }

    @Test(groups = {"regression"})
    public void editDriverWithValidDataTest() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        ElarAppDriversPage elarAppDriversPage=new ElarAppDriversPage();
        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        createDriver();

        elarAppNewDriverPage.goToEditButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 500)");
        String driverId=elarAppNewDriverPage.driverId.getAttribute("value");
        elarAppNewDriverPage.editButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -800)");
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.addName);
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        elarAppNewDriverPage.addName.sendKeys("Alex Doe");
        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(1000);
        elarAppNewDriverPage.drivingLcnInput.click();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.drivingLcnInput);
        Thread.sleep(1000);
        elarAppNewDriverPage.drivingLicenseBtn.click();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].value = arguments[1];",elarAppNewDriverPage.drivingLcnInput,"07/01/2025");
        Thread.sleep(1000);
        elarAppNewDriverPage.ipassNum.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 500)");
        elarAppNewDriverPage.updateButton.click();

        // Validation steps - Assertion
        String expectedName="Alex Doe";
        String expectedDLExp="07/01/2025";
        String actualName=elarAppNewDriverPage.addName.getAttribute("value");
        String actualDLExp=elarAppNewDriverPage.drivingLcnInput.getAttribute("value");
        Assert.assertEquals(expectedName,actualName);
//        Assert.assertEquals(expectedDLExp,actualDLExp);

        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -1400)");
        elarAppNewDriverPage.backToListButton.click();
        elarAppNewDriverPage.allDriversTabButton.click();
        Thread.sleep(1000);
        elarAppDriversPage.searchBox.click();
        elarAppDriversPage.searchBox.sendKeys(driverId+ Keys.ENTER);
        Thread.sleep(1000);
        List<WebElement> allDriversIds=elarAppNewDriverPage.allDriversFromList;
        allDriversIds.get(allDriversIds.size()-1).click();
        String actualNameInEditPage=elarAppNewDriverPage.addName.getAttribute("value");
        Assert.assertEquals(expectedName,actualNameInEditPage);

    }
    @Test(groups = {"regression"})
    public void editDriverWithInvalidDataTest() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        createDriver();

        elarAppNewDriverPage.goToEditButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 1000)");
        elarAppNewDriverPage.editButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -1800)");
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.addName);
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        elarAppNewDriverPage.addName.sendKeys("@#$%%^&*");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 5000)");
        elarAppNewDriverPage.updateButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -5000)");
        String nameErrorMessage = elarAppNewDriverPage.nameErrorMessage.getText();
        Thread.sleep(1000);

        // Validation steps - Assertion
        String expectedMessage="Input must contain only alphanumeric and specific punctuation characters";
        Assert.assertEquals(expectedMessage,nameErrorMessage);
    }

    @Test(groups = {"regression"})
    public void editDriverCancelButtonTest() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        createDriver();
        elarAppNewDriverPage.goToEditButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 1000)");
        elarAppNewDriverPage.editButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -1800)");
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.addName);
        Thread.sleep(1000);
        elarAppNewDriverPage.addName.click();
        elarAppNewDriverPage.addName.sendKeys("Alex Doe");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, 5000)");
        elarAppNewDriverPage.cancelButton.click();
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0, -5000)");
        String expectedName="John Doe";
        String actualName=elarAppNewDriverPage.addName.getAttribute("value");
        Assert.assertEquals(expectedName,actualName);

    }

}
