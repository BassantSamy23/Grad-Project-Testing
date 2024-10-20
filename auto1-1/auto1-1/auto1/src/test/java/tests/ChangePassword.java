package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.ChangePassPage;
import Pages.SecureAreaPage;
import Pages.ShoppingPage;

public class ChangePassword {

    WebDriver driver;
    ChangePassPage ChangePassPage;
    ShoppingPage ShoppingPage;
    SecureAreaPage SecureAreaPage;




    @BeforeClass
    public void PreCondition(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        ChangePassPage = new ChangePassPage(driver);
        ShoppingPage = new ShoppingPage(driver);
        SecureAreaPage = new SecureAreaPage(driver);
    }

    String ValidNewPass =   "1234";

    @Test(priority = 1)
    public void ChangePasswordSuccessfully(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().EnterLoginPage().Login("Ahmed@#");
        ChangePassPage.EnterPasswordPage().ChangePassword(ValidNewPass, ValidNewPass).ContinueButton();
        Assert.assertTrue(SecureAreaPage.ChangePass());
    }

    @Test(priority = 2)
    public void InvalidShortPassword(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().MyAccountPage();
        ChangePassPage.EnterPasswordPage().ChangePassword("23", "23").ContinueButton();
        Assert.assertTrue(SecureAreaPage.InvalidPassword());
    }

    @Test(priority = 2)
    public void InvalidVeryLongPassword(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().MyAccountPage();
        ChangePassPage.EnterPasswordPage().ChangePassword("23256846513546853548683453edmnbnjnnkjnkjnkn"
                , "23256846513546853548683453edmnbnjnnkjnkjnkn").ContinueButton();
        Assert.assertTrue(SecureAreaPage.InvalidPassword());
    }

    @Test(priority = 3)
    public void SpecialCharPassword(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().MyAccountPage();
        ChangePassPage.EnterPasswordPage().ChangePassword("Ahmed@#", "Ahmed@#").ContinueButton();
        Assert.assertTrue(SecureAreaPage.ChangePass());
    }

    @Test(priority = 4)
    public void ValidPasswordInvalidConfirmPassword(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().MyAccountPage();
        ChangePassPage.EnterPasswordPage().ChangePassword("Ahmed@#", "1234").ContinueButton();
        Assert.assertTrue(SecureAreaPage.InvalidConfirmPassword());
    }

    @AfterClass
    public void PostCondition(){
        driver.quit();
   }

}
