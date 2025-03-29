package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ElarAppLoginPage;
import pages.ElarAppNewDriverPage;
import utilities.ConfigReader;
import utilities.Driver;

public class newDriverTest {
    WebDriver driver;


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

    @Test
    public void positiveCredentials (){
        addNewDriver();
        driver.findElement(By.xpath("//input[@value='is_staff']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("John Doe");
        driver.findElement(By.id("uniforms-0003-0003")).click();
        driver.findElement(By.id("uniforms-0003-0004")).click();
        driver.findElement(By.xpath("//li[@data-value='GA']")).click();

        driver.findElement(By.xpath("(//button[@tabindex='0'])[7]")).click();
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("5497822336");
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
        driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("4045643216");
        driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
        driver.findElement(By.xpath("(//input[@type='tel'])[3]")).sendKeys("5459873654");


    }
}
