package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SecureAreaPage;
import Pages.ShoppingPage;



public class ShoppingCart {
    WebDriver driver;
    SecureAreaPage SecureAreaPage;
    ShoppingPage ShoppingPage;

    @BeforeClass
    public void precondition(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        SecureAreaPage = new SecureAreaPage(driver);
        ShoppingPage = new ShoppingPage(driver);
    }

    @Test(priority = 1)
    public void ValidateEmptyShoppingPage(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Your shopping cart is empty!"));
    }

    @Test(priority = 3)
    public void AddProductSuccessfullyToCart(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product1().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
    }

    @Test(priority = 3)
    public void  ContinueShoppingSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product1().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        Assert.assertTrue(SecureAreaPage.ShoppingPage("MacBook"));
        ShoppingPage.ContinueShButton().click();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product2().shoppingButton().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("iPhone"));
    }

    @Test(priority = 3)
    public void AddMoreQuaProductSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.ProductPage1("MacBook").click();
        ShoppingPage.InputQuantity("10");
        ShoppingPage.ButtonCart().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        //Assert.assertEquals(SecureAreaPage.ProductQua(),"10");
    }

    @Test(priority = 2)
    public void EmptyQuaProductSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product2().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        ShoppingPage.EmptyProduct_Qua();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Your shopping cart is empty!"));
    }
    @Test(priority = 3)
    public void AddingQuaProductSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product2().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        ShoppingPage.UpdateProduct_Qua("10");
    }

    @Test(priority = 3)
    public void ShippingEstimateProductSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        ShoppingPage.ShippingEstimate();
    }

    @Test(priority = 4)
    public void InvalidCouponCodeProduct(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product2().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        ShoppingPage.CouponCode("5689");
        Assert.assertTrue(SecureAreaPage.MessageShoppingPage(
                "Warning: Coupon is either invalid, expired or reached its usage limit!"));
    }

    @Test(priority = 4)
    public void InvalidCertificateCodeProduct(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product2().shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Shopping Cart"));
        ShoppingPage.CertificateCode("5689");
        Assert.assertTrue(SecureAreaPage.MessageShoppingPage(
                "Warning: Gift Certificate is either invalid or the balance has been used up!"));
    }

    @Test(priority = 3)
    public void  AddingVariousProductsSuccessfully(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Product1().Product2().TabletsBar().Product3().click();
        ShoppingPage.shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("MacBook"));
        Assert.assertTrue(SecureAreaPage.ShoppingPage("iPhone"));
        Assert.assertTrue(SecureAreaPage.ShoppingPage("Samsung Galaxy Tab 10.1"));
    }

    @Test(priority = 3)
    public void  Apple_cinemaValidateErrorMessageRadio(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Apple_CProduct().OptionsNoRadioSlc("Testing Process");
        ShoppingPage.ButtonCart();
        Assert.assertTrue(SecureAreaPage.ValidateErrorMessage("Radio required!"));
    }

    @Test(priority = 3)
    public void  Apple_cinemaValidateErrorMessageCheckbox(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Apple_CProduct().OptionsNoCheckboxSlc("Testing Process");
        ShoppingPage.ButtonCart();
        Assert.assertTrue(SecureAreaPage.ValidateErrorMessage("Checkbox required!"));
    }
    @Test(priority = 3)
    public void  Apple_cinemaValidateErrorMessageColor() {
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Apple_CProduct().OptionsNoColorSlc("Testing Process");
        ShoppingPage.ButtonCart();
        Assert.assertTrue(SecureAreaPage.ValidateErrorMessage("Select required!"));
    }

    @Test(priority = 3)
    public void  Apple_cinemaValidateErrorMessageTextarea(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Apple_CProduct().OptionsSlc("");
        ShoppingPage.ButtonCart();
        Assert.assertTrue(SecureAreaPage.ValidateErrorMessage("Textarea required!"));
    }

    @Test(priority = 3)
    public void  Apple_cinemaValidateErrorMessageFileUpload(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.Apple_CProduct().OptionsSlc("Testing Process");
        ShoppingPage.ButtonCart();
        Assert.assertTrue(SecureAreaPage.ValidateErrorMessage("File required!"));
    }

    @Test(priority = 3)
    public void  AddingProductNotAvailable(){
        ShoppingPage.Navigate();
        Assert.assertTrue(SecureAreaPage.HomePage());
        ShoppingPage.TabletsBar().Product3().click();
        ShoppingPage.shoppingButton();
        Assert.assertTrue(SecureAreaPage.ShoppingPage("***"));
        Assert.assertTrue(SecureAreaPage.NotAvailableErrorMessage());
    }

   @AfterClass
   public void PostCondition(){
       driver.quit();
   }
}
