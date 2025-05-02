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

    @Test
    public void editDriverWithValidDataTest() throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage=new ElarAppDriversPage();
        ElarAppUtility elarAppUtility=new ElarAppUtility();
        elarAppUtility.addNewDriver();

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("John Doe");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        Thread.sleep(2000);
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
        Thread.sleep(2000);

        elarAppNewDriverPage.goToEditButton.click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, 500)");
        String driverId=elarAppNewDriverPage.driverId.getAttribute("value");
        elarAppNewDriverPage.editButton.click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, -800)");
        Thread.sleep(2000);
        elarAppNewDriverPage.addName.click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.addName);
        Thread.sleep(2000);
        elarAppNewDriverPage.addName.click();
        elarAppNewDriverPage.addName.sendKeys("Alex Doe");
        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(2000);
        elarAppNewDriverPage.drivingLcnInput.click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.drivingLcnInput);
        Thread.sleep(2000);
//        elarAppNewDriverPage.drivingLcnInput.click();
        elarAppNewDriverPage.drivingLicenseBtn.click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].value = arguments[1];",elarAppNewDriverPage.drivingLcnInput,"07/01/2025");
//        elarAppNewDriverPage.drivingLcnInput.sendKeys("07012025");
        Thread.sleep(2000);
        elarAppNewDriverPage.ipassNum.click();
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, 500)");
        elarAppNewDriverPage.updateButton.click();

        // Validation steps - Assertion
        String expectedName="Alex Doe";
        String expectedDLExp="07/01/2025";
        String actualName=elarAppNewDriverPage.addName.getAttribute("value");
        String actualDLExp=elarAppNewDriverPage.drivingLcnInput.getAttribute("value");
        Assert.assertEquals(expectedName,actualName);
//        Assert.assertEquals(expectedDLExp,actualDLExp);

        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0, -1400)");
        elarAppNewDriverPage.backToListButton.click();

        elarAppNewDriverPage.allDriversTabButton.click();
        Thread.sleep(2000);
        elarAppDriversPage.searchBox.click();
        elarAppDriversPage.searchBox.sendKeys(driverId+ Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> allDriversIds=elarAppNewDriverPage.allDriversFromList;

        allDriversIds.get(allDriversIds.size()-1).click();
        String actualNameInEditPage=elarAppNewDriverPage.addName.getAttribute("value");
        Assert.assertEquals(expectedName,actualNameInEditPage);

    }
    @Test
    public void EditDriverWithInvalidDataTest() throws InterruptedException {
        ElarAppDriversPage elarAppDriversPage=new ElarAppDriversPage();
        ElarAppUtility elarAppUtility=new ElarAppUtility();
        elarAppUtility.addNewDriver();

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();
        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("John Doe");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        Thread.sleep(2000);
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
        Thread.sleep(2000);

        elarAppNewDriverPage.goToEditButton.click();
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0, 1000)");
//        String driverId=elarAppNewDriverPage.driverId.getAttribute("value");
        elarAppNewDriverPage.editButton.click();
        Thread.sleep(4000);
        jse.executeScript("window.scrollBy(0, -1800)");
        Thread.sleep(2000);
        elarAppNewDriverPage.addName.click();
        Thread.sleep(2000);
       jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.addName);

        Thread.sleep(2000);
        elarAppNewDriverPage.addName.click();
        elarAppNewDriverPage.addName.sendKeys("@#$%%^&*");
        elarAppNewDriverPage.drivingLcnInput.click();
        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(2000);
//
//        Thread.sleep(2000);
//        jse.executeScript("arguments[0].value = '';",elarAppNewDriverPage.drivingLcnInput);
//        Thread.sleep(2000);
////        elarAppNewDriverPage.drivingLcnInput.click();
//        elarAppNewDriverPage.drivingLicenseBtn.click();
//        Thread.sleep(2000);
//        jse.executeScript("arguments[0].value = arguments[1];",elarAppNewDriverPage.drivingLcnInput,"07/01/2025");
////        elarAppNewDriverPage.drivingLcnInput.sendKeys("07012025");
//        Thread.sleep(2000);
//        elarAppNewDriverPage.ipassNum.click();
//        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0, 5000)");
        elarAppNewDriverPage.updateButton.click();
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0, -5000)");
        String alert = elarAppNewDriverPage.messageAlert.getText();
        Thread.sleep(5000);

        // Validation steps - Assertion
        String expectedMessage="Input must contain only alphanumeric and specific punctuation characters";
       // String expectedDLExp="07/01/2025";

        String actualDLExp=elarAppNewDriverPage.drivingLcnInput.getAttribute("value");

        Assert.assertEquals(expectedMessage,alert);
//        Assert.assertEquals(expectedDLExp,actualDLExp);

//        Thread.sleep(2000);
//        jse.executeScript("window.scrollBy(0, -1400)");
//        elarAppNewDriverPage.backToListButton.click();
//
//        elarAppNewDriverPage.allDriversTabButton.click();
//        Thread.sleep(2000);
//        elarAppDriversPage.searchBox.click();
//        elarAppDriversPage.searchBox.sendKeys(driverId+ Keys.ENTER);
//        Thread.sleep(2000);
//        List<WebElement> allDriversIds=elarAppNewDriverPage.allDriversFromList;
//
//        allDriversIds.get(allDriversIds.size()-1).click();
//        String actualNameInEditPage=elarAppNewDriverPage.addName.getAttribute("value");
//        Assert.assertEquals(expectedName,actualNameInEditPage);

    }

}
