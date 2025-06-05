package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.ElarAppNewDriverPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class UpdateDriverTest {

    WebDriver driver;

    public void beginNewDriver(){
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
    public void NormalCredentials () throws InterruptedException {
        beginNewDriver();
//        Actions actions = new Actions(driver);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollBy(0, 4000)");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();



        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("Russel Ham");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        elarAppNewDriverPage.georgiaState.click();
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        elarAppNewDriverPage.addPhoneBtn1.click();
        elarAppNewDriverPage.inputPhone1.sendKeys("5127899076");
        elarAppNewDriverPage.addPhoneBtn2.click();
        elarAppNewDriverPage.inputPhone2.sendKeys("7734562345");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addPhoneBtn3.click();
        elarAppNewDriverPage.inputPhone3.sendKeys("5519871234");

        elarAppNewDriverPage.addEmailBtn1.click();
        elarAppNewDriverPage.inputEmail1.sendKeys("russel.ham@gmail.com");
        elarAppNewDriverPage.addEmailBtn2.click();
        elarAppNewDriverPage.inputEmail2.sendKeys("456@gmail.com");
        elarAppNewDriverPage.addEmailBtn3.click();
        elarAppNewDriverPage.inputEmail3.sendKeys("thisishim@gmail.com");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addSkypeBtn.click();
        elarAppNewDriverPage.inputSkype.sendKeys("Russel Ham");
        elarAppNewDriverPage.addSkype2.click();
        elarAppNewDriverPage.inputSkype2.sendKeys("Russel.Ham");
        elarAppNewDriverPage.addSkype3.click();
        elarAppNewDriverPage.inputSkype3.sendKeys("russelham");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addViberBtn.click();
        elarAppNewDriverPage.inputViberBtn.sendKeys("5127899076");
        elarAppNewDriverPage.addViber2.click();
        elarAppNewDriverPage.inputViber2.sendKeys("7734562345");
        elarAppNewDriverPage.addViber3.click();
        elarAppNewDriverPage.inputViber3.sendKeys("5519871234");
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
        elarAppNewDriverPage.logBookEmail.sendKeys("pthirty@gmail.com");
//        elarAppNewDriverPage.logBookPswd.click();
        Thread.sleep(3000);
        elarAppNewDriverPage.logBookPswd.sendKeys("678900");
        Thread.sleep(3000);
//        elarAppNewDriverPage.manualID.click();
        elarAppNewDriverPage.manualID.sendKeys("123456789999");
//        elarAppNewDriverPage.warning.click();
        elarAppNewDriverPage.warning.sendKeys("Be careful");
//        elarAppNewDriverPage.notes.click();
        elarAppNewDriverPage.notes.sendKeys("He is a good driver");

        elarAppNewDriverPage.createBtn.click();

    }

    @Test
    public void updatedCredentials() throws InterruptedException{
        beginNewDriver();
//        Actions actions = new Actions(driver);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollBy(0, 4000)");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        ElarAppNewDriverPage elarAppNewDriverPage = new ElarAppNewDriverPage();



        elarAppNewDriverPage.stuffBtn.click();
        elarAppNewDriverPage.addName.sendKeys("Russel Ham");
        elarAppNewDriverPage.localBtn.click();
        elarAppNewDriverPage.localStateDropBox.click();
        elarAppNewDriverPage.georgiaState.click();
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        elarAppNewDriverPage.addPhoneBtn1.click();
        elarAppNewDriverPage.inputPhone1.sendKeys("5127899076");
        elarAppNewDriverPage.addPhoneBtn2.click();
        elarAppNewDriverPage.inputPhone2.sendKeys("7734562345");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addPhoneBtn3.click();
        elarAppNewDriverPage.inputPhone3.sendKeys("5519871234");

        elarAppNewDriverPage.addEmailBtn1.click();
        elarAppNewDriverPage.inputEmail1.sendKeys("russel.ham@gmail.com");
        elarAppNewDriverPage.addEmailBtn2.click();
        elarAppNewDriverPage.inputEmail2.sendKeys("456@gmail.com");
        elarAppNewDriverPage.addEmailBtn3.click();
        elarAppNewDriverPage.inputEmail3.sendKeys("thisishim@gmail.com");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addSkypeBtn.click();
        elarAppNewDriverPage.inputSkype.sendKeys("Russel Ham");
        elarAppNewDriverPage.addSkype2.click();
        elarAppNewDriverPage.inputSkype2.sendKeys("Russel.Ham");
        elarAppNewDriverPage.addSkype3.click();
        elarAppNewDriverPage.inputSkype3.sendKeys("russelham");
        jse.executeScript("window.scrollBy(0, 200)");
        elarAppNewDriverPage.addViberBtn.click();
        elarAppNewDriverPage.inputViberBtn.sendKeys("5127899076");
        elarAppNewDriverPage.addViber2.click();
        elarAppNewDriverPage.inputViber2.sendKeys("7734562345");
        elarAppNewDriverPage.addViber3.click();
        elarAppNewDriverPage.inputViber3.sendKeys("5519871234");
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
        elarAppNewDriverPage.logBookEmail.sendKeys("pthirty@gmail.com");
//        elarAppNewDriverPage.logBookPswd.click();
        Thread.sleep(3000);
        elarAppNewDriverPage.logBookPswd.sendKeys("678900");
        Thread.sleep(3000);
//        elarAppNewDriverPage.manualID.click();
        elarAppNewDriverPage.manualID.sendKeys("123456789999");
//        elarAppNewDriverPage.warning.click();
        elarAppNewDriverPage.warning.sendKeys("Be careful");
//        elarAppNewDriverPage.notes.click();
        elarAppNewDriverPage.notes.sendKeys("He is a good driver");

        elarAppNewDriverPage.createBtn.click();
//
//        elarAppNewDriverPage.goToEditBtn.click();
//        jse.executeScript("window.scrollBy(0, 1000)");
//        elarAppNewDriverPage.editBtnMain.click();
//        jse.executeScript("window.scrollBy(0,-1000");
//        elarAppNewDriverPage.statusBtn.click();
//        elarAppNewDriverPage.onDutyBtn.click();
//        elarAppNewDriverPage.addName.sendKeys("Russel Hamilton");
//        elarAppNewDriverPage.drivingLcnInput.click();
//        elarAppNewDriverPage.drivingLcnInput.sendKeys("06272025");
//        elarAppNewDriverPage.medicalLcnInput.click();
//        elarAppNewDriverPage.medicalLcnInput.sendKeys("06272025");
//        elarAppNewDriverPage.updateBtn.click();
    }
}


