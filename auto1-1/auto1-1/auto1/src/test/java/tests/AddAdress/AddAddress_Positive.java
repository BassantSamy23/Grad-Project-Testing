package tests.AddAdress;

import Pages.AccountAddressPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ShoppingPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddAddress_Positive extends TestBase {

    //Pages object

    AccountAddressPage accountAddress;
    ShoppingPage shoppingPage;
    HomePage homePage;
    CheckoutPage checkout;

    @BeforeClass
    public void preConditions(){
        accountAddress = new AccountAddressPage(driver);
        shoppingPage = new ShoppingPage(driver);
        homePage = new HomePage(driver);
        checkout = new CheckoutPage(driver);
    }

    @Test (priority = 1)     //Add new address
    public void validateAddNewAddress() {
        accountAddress
                .clickNewAddress()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterCompany(company)
                .enterAddress1(address1)
                .enterAddress2(address2)
                .enterCity(city)
                .enterPostCode(postCode)
                .selectCountry(country)
                .selectState(state)
                .selectDefaultAddress()
                .clickContinue()
                .validateAddAddress();
    }
    @Test (priority = 2)
    public void validateAddressData(){
        Integer index;          //Index of the table that contain the matched data
        index = accountAddress.validateAddress1And2(address1 + "\n" + address2);
        accountAddress
                .validateAddressName(firstName + " " + lastName, index)
                .validateAddressCompany(company, index)
                .validateAddressCity(city + " " + postCode, index)
                .validateAddressState(state, index)
                .validateAddressCountry(country, index);
    }
    @Test  (priority = 3)      //Validate address data in checkout and default option
    public void validateAddressInCheckOut(){
        homePage.enterQuery("Iphone");
        shoppingPage.Product2Sea().Navigate().Product1();
        shoppingPage.shoppingButton();
        homePage.navigateCheckout();
        checkout.validateAddressData(firstName + " " + lastName, address1, city, state, country);
    }
}

