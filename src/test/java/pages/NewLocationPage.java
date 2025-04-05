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

    @FindBy(xpath = "(//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeLarge css-coclz'])[1]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//button[@type='button'])[17]")
    public WebElement createNew;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameHeader;

    @FindBy(xpath = "//div[@class='MuiDataGrid-columnHeaderTitle css-mh3zap']")
    public WebElement addressInput;
}
