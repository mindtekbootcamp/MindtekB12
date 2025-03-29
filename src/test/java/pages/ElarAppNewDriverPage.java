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

}
