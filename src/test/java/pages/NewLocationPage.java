package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NewLocationPage {
    WebDriver driver;

    public NewLocationPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-otz8yo'])[5]")
    public WebElement driverBtn;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement addDriver;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//button[@type='button'])[17]")
    public WebElement createNew;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameHeader;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[3]")
    public WebElement stateInput;

    @FindBy(xpath = "//li[@data-value='TX']")
    public WebElement texasBtn;

    @FindBy(xpath = "//input[@name='zip_code']")
    public WebElement zipcodeInput;

    @FindBy(xpath = "//input[@name='apt_suite_company_co']")
    public WebElement aptSuite;

    @FindBy(xpath = "(//button[@type='button'])[20]")
    public WebElement createBtn;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement deleteBtn;


}
