package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarAppNewDriverPage {
    WebDriver driver;

    public ElarAppNewDriverPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-otz8yo'])[5]")
    public WebElement driverPage;

    @FindBy(xpath = "(//button[@tabindex='0'])[5]")
    public WebElement addNewDriverButton;

    public void elarAppNewDriverPage(){
        driverPage.click();
        addNewDriverButton.click();
    }

    @FindBy(xpath = "//input[@value='is_staff']")
    public WebElement stuffBtn;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement addName;

    @FindBy(xpath = "//input[@name='is_local']")
    public WebElement localBtn;

    @FindBy(xpath = "//div[@role='combobox']")
    public WebElement localStateDropBox;


    @FindBy(xpath = "//li[@data-value='GA']")
    public WebElement georgiaState;

    @FindBy(xpath = "(//button[@tabindex='0'])[7]")
    public WebElement addPhoneBtn1;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement inputPhone1;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement addPhoneBtn2;

    @FindBy(xpath = "(//input[@type='tel'])[2]")
    public WebElement inputPhone2;

    @FindBy(xpath = "(//button[@type='button'])[9]")
    public WebElement addPhoneBtn3;

    @FindBy(xpath = "(//input[@type='tel'])[3]")
    public WebElement inputPhone3;

    @FindBy(xpath = "(//button[@type='button'])[10]")
    public WebElement addEmailBtn1;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement inputEmail1;

    @FindBy(xpath = "(//button[@type='button'])[11]")
    public WebElement addEmailBtn2;

    @FindBy(xpath = "(//input[@placeholder='Email'])[2]")
    public WebElement inputEmail2;

    @FindBy(xpath = "(//button[@type='button'])[12]")
    public WebElement addEmailBtn3;

    @FindBy(xpath = "(//input[@placeholder='Email'])[3]")
    public WebElement inputEmail3;






}
