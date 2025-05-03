package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ElarAppDriversPage {

    WebDriver driver;

    public ElarAppDriversPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[text()='Search...']/following::div/input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@aria-rowindex='2']//div[@data-field='id']/div")
    public WebElement driverIDSearchResult;

    @FindBy(xpath = "//div[@aria-rowindex='2']//div[@data-field='full_name']/div")
    public WebElement driverNameSearchResult;

    @FindBy(xpath = "//*[@id='searchPopper']/div/button[2]")
    public WebElement driverSearchByName;

    @FindBy(xpath = "//div[@data-colindex='2']//div[@role='presentation']")
    public List<WebElement> resultNames;

}
