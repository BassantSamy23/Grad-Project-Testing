package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.ChangePassPage;
import Pages.EditAccountPage;
import Pages.SecureAreaPage;
import Pages.ShoppingPage;

public class EditAccount {

    WebDriver driver;
    ChangePassPage ChangePassPage;
    ShoppingPage ShoppingPage;
    SecureAreaPage SecureAreaPage;
    EditAccountPage EditAccountPage;


    @BeforeClass
    public void PreCondition(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        ChangePassPage = new ChangePassPage(driver);
        ShoppingPage = new ShoppingPage(driver);
        SecureAreaPage = new SecureAreaPage(driver);
        EditAccountPage = new EditAccountPage(driver);
    }

    @Test(priority = 1)
    public void EditValidDetailsSuccessfully(){
        ShoppingPage.Navigate();
        ChangePassPage.MyAccount().EnterLoginPage().Login("Ahmed@#");
        EditAccountPage.EnterEditPage().EnterEditFirstName("Ahmed").EnterEditLastName("Hassan")
                       .EnterEditEmail("eprahimfathy@gmail.com").EnterEditTelephone("011274439");
        ChangePassPage.ContinueButton();
        Assert.assertTrue(SecureAreaPage.EditAccountMessage());
    }

    @Test(priority = 2)
    public void EditEmptyTelephoneItem(){
        EditAccountPage.EnterEditPage().EnterEditTelephone("");
        ChangePassPage.ContinueButton();
        Assert.assertTrue(SecureAreaPage.EditErrorTermMessage("Telephone must be between 3 and 32 characters!"));
    }
    @Test(priority = 3)
    public void EditInvalidEmailItem(){
        EditAccountPage.EnterEditPage().EnterEditEmail("eprahimfathy.gmail.com");
        ChangePassPage.ContinueButton();
    }

    @Test(priority = 2)
    public void EditInvalidFirstNameItem(){
        EditAccountPage.EnterEditPage().EnterEditFirstName("Ahmed Mohmed Hassan Ibrahim Kamal Abbas");
        ChangePassPage.ContinueButton();
        Assert.assertTrue(SecureAreaPage.EditErrorTermMessage("First Name must be between 1 and 32 characters!"));
    }

    @Test(priority = 2)
    public void EditEmptyItems(){
        EditAccountPage.EnterEditPage().EnterEditFirstName("").EnterEditLastName("")
                       .EnterEditEmail("").EnterEditTelephone("");
        ChangePassPage.ContinueButton();
        Assert.assertTrue(SecureAreaPage.EditErrorTermMessage("First Name must be between 1 and 32 characters!"));
    }

    @AfterClass
    public void PostCondition(){
        driver.quit();
    }
}
