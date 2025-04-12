package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class BrowserUtils {
    /**
     * This method accepts first name and last name as String values
     * and generates an email. with those values.
     *
     * @param firstName
     * @param lastName
     * @return
     */

    public static String randomEmailGenerator(String firstName, String lastName) {
        Random random = new Random();
        int randomNum = random.nextInt(999999);
        return firstName + "." + lastName + randomNum + "@fakemail.com";
    }
    public static String randomAddressGenerator() {
        Random random = new Random();
        int randomNum = random.nextInt(999999);
        return randomNum + " Kingsland st.";
    }

    public static void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
