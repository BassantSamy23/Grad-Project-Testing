package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotPasswordPage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    By forgetPasswordTitle= By.xpath("//h1[contains(text(),\"Forgot Your Password?\")]");
    By emailTextBox = By.id("input-email");
    By continueButton = By.cssSelector("input[type=\"submit\"]");
    By wrongEmailErrorMsg = By.cssSelector("div[class=\"alert alert-danger alert-dismissible\"]");

    public  ForgotPasswordPage verifyTheForgetPasswordPageAppears()
    {
        Assert.assertTrue(driver.findElement(forgetPasswordTitle).isDisplayed());
        return new ForgotPasswordPage(driver);
    }

    public LoginPage enterValidEmail(String email)
    {
        driver.findElement(emailTextBox).clear();
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(continueButton).click();
        return new LoginPage(driver);
    }

    public ForgotPasswordPage enterInvalidEmail(String email)
    {
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(continueButton).click();
        return new ForgotPasswordPage(driver);
    }

    public ForgotPasswordPage verifyErrorMSGDisplayed()
    {
        Assert.assertTrue(driver.findElement(wrongEmailErrorMsg).isDisplayed());
        return new ForgotPasswordPage(driver);
    }
}
