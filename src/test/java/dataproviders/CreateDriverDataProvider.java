package dataproviders;

import org.testng.annotations.DataProvider;

public class CreateDriverDataProvider {

    @DataProvider(name = "createInvalidNewAddress")
    public Object[][] createInvalidNewAddress() {
        return new Object[][]{
                {"354 abc", "Chicago", "Il", "253987", "Xyz"},
                {"122 h@g", "Forest Park", "Illinois", "60745", "P!ur"}
        };
    }

    @DataProvider(name = "addressSizeData")
    public Object[][] addressSizeData() {
        return new Object[][]{
                {1, "id"},
                {50, "address"},
                {99, "city"},
                {100, "state"},
                {5, "zip_code"},
                {10, "name"}
        };
    }

    @DataProvider(name = "createNewAddress")
    public Object[][] createNewAddress() {
        return new Object[][]{
                {"354 abc", "Chicago", "IL", "23987", "Xyz"},
                {"122 hyg", "Forest Park", "IL", "67415", "Plur"}
        };
    }

    @DataProvider(name = "validateSizeData")
    public Object[][] validateSizeData() {
        return new Object[][]{
                {-1, "Input should be greater than or equal to 1"},
                {101, "Input should be less than or equal to 100"}
        };
    }
}
