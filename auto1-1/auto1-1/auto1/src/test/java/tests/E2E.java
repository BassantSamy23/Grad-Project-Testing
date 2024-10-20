package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.*;

import java.time.Duration;

public class E2E {

    WebDriver driver;
    RegisterPage registerPage;
    LoginPage loginPage;
    SearchResults searchResults;
    ShoppingPage ShoppingPage;
    SecureAreaPage SecureAreaPage;
    HomePage homePage;

    @BeforeTest
    public void OpenBrowser(){
        driver =new FirefoxDriver();
        driver.manage().window().maximize();
        registerPage=new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        searchResults = new SearchResults(driver);
        ShoppingPage = new ShoppingPage(driver);
        SecureAreaPage = new SecureAreaPage(driver);
        homePage = new HomePage(driver);
    }

    String EmailAddress = "new204@gmail.com";

    @Test(priority = 1)
    public void successful_register(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email(EmailAddress);
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_successful_register();
    }
    @Test(priority = 2)
    public void testValidLogin() {
        loginPage.logout();
        loginPage.navigateToLogin();
        loginPage.login(EmailAddress, "11111");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account"), "User should be redirected to the account page after a successful login.");
    }
    @Test(priority = 3)
    public void validateSearch(){
        searchResults.search("Iphone");
    }

    @Test(priority = 4)
    public void AddProductSuccessfullyToCart(){
        ShoppingPage.Product2Sea().Navigate().Product1();
        ShoppingPage.shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
    }

    @Test (priority = 5)
    public void validateUserCheckoutAndConfirmOrderSuccessfully ()
    {
        homePage.navigateCheckout().checkoutPageAppearance().billingDetailsStepAppearance()
                .EnterDataForTheAddress("Bassant","Samy","AinShams","AinShams", "cairo" , "123456")
                .userChooseExistingAddress()
                .verifyMovingToDeliveryMethodSuccessfullyAfterContinue()
                .verifyFlatRateIsCheckedByDefault()
                .userEnterComment("comment")
                .verifyMovingToPaymentMethodSuccessfullyAfterContinue()
                .verifyPaymentMethodRadioIsCheckedByDefault()
                .checkTheTermsAndConditionBox()
                .clickingOnContinue()
                .verifyMovingToTheConfirmOrderAfterContinue()
                .verifyTheProductIsTheSameYouPurchased("iPhone","MacBook")
                .verifyTheQuantityOfProductsIsDiplayed()
                .verifyThePriceOfProductIsDiplayed()
                .verifyTheTotalPriceOfProductsIsDiplayed()
                .verifyTheShippingFeesIsDiplayed()
                .verifySuccessMSGWhenUserConfirmTheOrder()
                .verifyTheUserGoesToTheHomePageAfterClickingContinue();
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
