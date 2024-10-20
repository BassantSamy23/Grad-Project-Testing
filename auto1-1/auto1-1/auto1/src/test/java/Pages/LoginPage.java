package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver ;
    }

    By usernameField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.cssSelector("input[type='submit']");
    By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    By forgotPassword = By.xpath("(//a[contains(text(),\"Forgotten Password\")])[1]");
    By confirmationEmailMsg = By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"); //for the forgotten password

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorMessageVisible() {
        return driver.findElement(loginErrorMessage).isDisplayed();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessage).getText();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
    public void navigateToLogin(){
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
    }
    public void logout(){
        driver.get("https://awesomeqa.com/ui/index.php?route=account/logout");
    }

    public void clickOnForgetPass()
    {
        driver.findElement(forgotPassword).click();
    }

    public void verifyConfirmationEmailIsSentMSG ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationEmailMsg));
        Assert.assertTrue(driver.findElement(confirmationEmailMsg).isDisplayed());
    }


}
