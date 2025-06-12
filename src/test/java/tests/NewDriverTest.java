package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.ElarAppNewDriverPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class NewDriverTest {
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

    @Test(groups = {"regression"})
    public void positiveCredentials () throws InterruptedException {
        addNewDriver();
//        Actions actions = new Actions(driver);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollBy(0, 4000)");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();



        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("Jonathan Dondo");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        elarAppNewDriverPage.georgiaState.click();
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        elarAppNewDriverPage.addPhoneBtn1.click();
        elarAppNewDriverPage.inputPhone1.sendKeys("5127893654");
        elarAppNewDriverPage.addPhoneBtn2.click();
        elarAppNewDriverPage.inputPhone2.sendKeys("7734563214");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addPhoneBtn3.click();
        elarAppNewDriverPage.inputPhone3.sendKeys("5519874563");

        elarAppNewDriverPage.addEmailBtn1.click();
        elarAppNewDriverPage.inputEmail1.sendKeys("john.doe@gmail.com");
        elarAppNewDriverPage.addEmailBtn2.click();
        elarAppNewDriverPage.inputEmail2.sendKeys("123@gmail.com");
        elarAppNewDriverPage.addEmailBtn3.click();
        elarAppNewDriverPage.inputEmail3.sendKeys("thisisemail@gmail.com");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addSkypeBtn.click();
        elarAppNewDriverPage.inputSkype.sendKeys("John Doe");
        elarAppNewDriverPage.addSkype2.click();
        elarAppNewDriverPage.inputSkype2.sendKeys("John.Doe");
        elarAppNewDriverPage.addSkype3.click();
        elarAppNewDriverPage.inputSkype3.sendKeys("johndoe");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addViberBtn.click();
        elarAppNewDriverPage.inputViberBtn.sendKeys("5517893654");
        elarAppNewDriverPage.addViber2.click();
        elarAppNewDriverPage.inputViber2.sendKeys("7735648941");
        elarAppNewDriverPage.addViber3.click();
        elarAppNewDriverPage.inputViber3.sendKeys("3127893654");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.otherBtn.click();
        elarAppNewDriverPage.inputOther.sendKeys("7707062890");
        elarAppNewDriverPage.otherBtn2.click();
        elarAppNewDriverPage.inputOther2.sendKeys("7707891478");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.otherBtn3.click();
        elarAppNewDriverPage.inputOther3.sendKeys("9283601738");

//        elarAppNewDriverPage.addressBtn.click();
//        elarAppNewDriverPage.addAddress.click();

//        elarAppNewDriverPage.drivingLicenseBtn.click();
//        elarAppNewDriverPage.datePicked1.click();

          elarAppNewDriverPage.drivingLcnInput.click();
        elarAppNewDriverPage.drivingLcnInput.sendKeys("04272025");

//        elarAppNewDriverPage.medicalLicenseBtn.click();
//        elarAppNewDriverPage.datePicked2.click();

        elarAppNewDriverPage.medicalLcnInput.click();
        elarAppNewDriverPage.medicalLcnInput.sendKeys("04272025");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.twicCheckbox.click();

//        elarAppNewDriverPage.ipassNum.click();
        elarAppNewDriverPage.ipassNum.sendKeys("123456789");
//        elarAppNewDriverPage.logbookNum.click();
        elarAppNewDriverPage.logbookNum.sendKeys("123456789");
        jse.executeScript("window.scrollBy(0, 200)");
//        elarAppNewDriverPage.logBookEmail.click();
        elarAppNewDriverPage.logBookEmail.sendKeys("qwerty@gmail.com");
//        elarAppNewDriverPage.logBookPswd.click();
        Thread.sleep(3000);
        elarAppNewDriverPage.logBookPswd.sendKeys("123456");
        Thread.sleep(3000);
//        elarAppNewDriverPage.manualID.click();
        elarAppNewDriverPage.manualID.sendKeys("123456789999");
//        elarAppNewDriverPage.warning.click();
        elarAppNewDriverPage.warning.sendKeys("Be careful");
//        elarAppNewDriverPage.notes.click();
        elarAppNewDriverPage.notes.sendKeys("He is a good driver");

        elarAppNewDriverPage.createBtn.click();

    }
}
