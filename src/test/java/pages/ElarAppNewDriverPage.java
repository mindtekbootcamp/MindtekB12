package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.security.interfaces.XECPrivateKey;
import java.util.List;

public class ElarAppNewDriverPage {
    WebDriver driver;

    public ElarAppNewDriverPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-otz8yo'])[5]")
    public WebElement driverPage;

    @FindBy(xpath = "//button[@type='button' and text()='Add driver']")
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

    @FindBy(xpath = "//li[@data-value='NY']")
    public WebElement newYorkState;

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

    @FindBy(xpath = "//*[@id='root']/div[1]/main/div[2]/div/div/div/form/button[2]")
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

    @FindBy(xpath = "(//button[@type='button'])[13]")
    public  WebElement addSkypeBtn;

    @FindBy(xpath = "(//input[@type='string'])[7]")
    public WebElement inputSkype;

    @FindBy(xpath = "(//button[@type='button'])[14]")
    public WebElement addSkype2;

    @FindBy(xpath = "(//input[@type='string'])[8]")
    public WebElement inputSkype2;

    @FindBy(xpath = "(//button[@type='button'])[15]")
    public WebElement addSkype3;

    @FindBy(xpath = "(//input[@type='string'])[9]")
    public WebElement inputSkype3;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement addViberBtn;

    @FindBy(xpath = "(//input[@type='string'])[10]")
    public WebElement inputViberBtn;

    @FindBy(xpath = "(//button[@type='button'])[17]")
    public WebElement addViber2;

    @FindBy(xpath = "(//input[@type='string'])[11]")
    public WebElement inputViber2;

    @FindBy(xpath = "(//button[@type='button'])[18]")
    public WebElement addViber3;

    @FindBy(xpath = "(//input[@type='string'])[12]")
    public WebElement inputViber3;

    @FindBy(xpath = "(//button[@type='button'])[19]")
    public WebElement otherBtn;

    @FindBy(xpath = "(//input[@type='string'])[13]")
    public WebElement inputOther;

    @FindBy(xpath = "(//button[@type='button'])[20]")
    public WebElement otherBtn2;

    @FindBy(xpath = "(//input[@type='string'])[14]")
    public WebElement inputOther2;

    @FindBy(xpath = "(//button[@type='button'])[21]")
    public WebElement otherBtn3;

    @FindBy(xpath = "(//input[@type='string'])[15]")
    public WebElement inputOther3;

    @FindBy(xpath = "(//button[@type='button'])[12]")
    public WebElement addressBtn;

    @FindBy(xpath = "(//div[@data-field='address'])[2]")
    public WebElement addAddress;

    @FindBy(xpath = "(//input[@name='driving_license_exp']/following::div/button[@type='button'])[1]")
    public WebElement drivingLicenseBtn;

    @FindBy(xpath = "//input[@name='driving_license_exp']")
    public WebElement drivingLcnInput;

    @FindBy(xpath = "(//button[@type='button'])[41]")
    public  WebElement datePicked1;

    @FindBy(xpath = "(//button[@type='button'])[15]")
    public WebElement medicalLicenseBtn;

    @FindBy(xpath = "//input[@name='medical_certification_exp']")
    public WebElement medicalLcnInput;

    @FindBy(xpath = "(//button[@type='button'])[45]")
    public WebElement datePicked2;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement twicCheckbox;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement ipassNum;

    @FindBy(xpath = "(//input[@type='text'])[8]")
    public WebElement logbookNum;

    @FindBy(xpath = "//input[@name='logbook_email']")
    public WebElement logBookEmail;

    @FindBy(xpath = "//input[@name='logbook_password']")
    public WebElement logBookPswd;

    @FindBy(xpath = "(//input[@type='text'])[11]")
    public WebElement manualID;

    @FindBy(xpath = "(//input[@type='text'])[12]")
    public WebElement warning;

    @FindBy(xpath = "//textarea[@name='notes']")
    public WebElement notes;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createBtn;

    @FindBy(xpath = "//button[text()='Go to Edit']")
    public WebElement goToEditButton;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[text()='Back to list']")
    public WebElement backToListButton;

    @FindBy(xpath = "//div[@aria-label]/button[@type='button'][1]")
    public WebElement allDriversTabButton;

    @FindBy(xpath = "//div[@data-field='id' and @aria-colindex='2']")
    public List<WebElement> allDriversFromList;

    @FindBy(xpath = "//span[text()='Manual id']//parent:: legend//parent:: fieldset//preceding-sibling::input")
    public WebElement driverId;

    @FindBy(xpath = "//p[text()='Input must contain only alphanumeric and specific punctuation characters']")
    public WebElement nameErrorMessage;


}
