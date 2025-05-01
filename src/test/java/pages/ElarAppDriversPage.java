package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarAppDriversPage {

    WebDriver driver;

    public ElarAppDriversPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[text()='Search...']/following::div/input[@type='text']")
    public WebElement searchBox;

}
