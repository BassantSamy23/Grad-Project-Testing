package tests;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgetPasswordTest {
    WebDriver driver;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    @BeforeClass
    public void ForgetPassPreconditions()
    {
        driver =new FirefoxDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        forgotPasswordPage =new ForgotPasswordPage(driver);
    }
    @Test(priority = 1)
    public void userNavigateToLoginPage()
    {
        loginPage.navigateToLogin();
    }
    @Test(priority = 2)
    public void userClickOnForgetPass()
    {
        loginPage.clickOnForgetPass();
    }
    @Test(priority = 3)
    public void verifyUserMovesToTheForgetPassPage ()
    {
        forgotPasswordPage.verifyTheForgetPasswordPageAppears();
    }
    @Test(priority = 4)
    public void verifyErrorMSGDisplayedWhenUserEnterInvalidEmail ()
    {
        forgotPasswordPage.enterInvalidEmail("Invalid@gmail.com").verifyErrorMSGDisplayed();
    }
    @Test(priority = 5)
    public void verifyAnEmailIsSentWhenUserEnterValidEmail()
    {
        forgotPasswordPage.enterValidEmail("New113@gmail.com").verifyConfirmationEmailIsSentMSG();
    }

    @AfterClass
    public void flush()
    {
        driver.quit();
    }

}
