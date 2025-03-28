package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;


    public class ElarAppLoginPage {
        WebDriver driver;

        public ElarAppLoginPage(){
            driver= Driver.getDriver();
            PageFactory.initElements(driver,this);
        }
        @FindBy(id = "login-username")
        public WebElement userNameInput;

        public void elarAppLoginPage(String userNameKey, String passwordKey){
            userNameInput.sendKeys(ConfigReader.getProperty(userNameKey));
            passwordInput.sendKeys(ConfigReader.getProperty(passwordKey));
            loginButton.click();
        }

        @FindBy(id = "login-password")
        public WebElement passwordInput;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement loginButton;
}
