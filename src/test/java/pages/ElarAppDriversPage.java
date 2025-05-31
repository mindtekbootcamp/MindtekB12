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

    @FindBy(xpath = "//div[@role='cell' and @data-field='id' and not(contains(@class, 'hidden'))]")
    public List<WebElement> resultNames2;

    @FindBy(xpath = "//p[text()='Rows per page:']/following::div/div")
    public WebElement rowsPerPage;

    @FindBy(xpath = "//button[@title='Go to next page']")
    public WebElement goToNextPage;

    @FindBy(xpath = "//li[@data-value='5']")
    public WebElement fiveDriversButton;

    @FindBy(xpath = "//li[@data-value='10']")
    public WebElement tenDriversButton;

    @FindBy(xpath = "//li[@data-value='25']")
    public WebElement twentyFiveButton;

    @FindBy(xpath = "//div[@class='MuiDataGrid-virtualScroller css-1pzb349']")
    public WebElement virtualScroller;

    @FindBy(xpath = "//button[text()='Email/Phone']")
    public WebElement searchByEmail;





}
