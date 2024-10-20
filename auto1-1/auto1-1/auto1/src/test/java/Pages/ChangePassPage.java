package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePassPage {

    WebDriver driver;

    public ChangePassPage(WebDriver driver) {
        this.driver = driver;
    }

    By MyAccount_textBox = By.cssSelector("a[title=\"My Account\"]");
    By LoginPage_textBox = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=account/login\"]");
    By PasswordPage_textBox = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=account/password\"]");
    By Password_textBox = By.id("input-password");
    By ConfirmPassword_textBox = By.id("input-confirm");
    By ContinueButton_textBox = By.cssSelector("input[class=\"btn btn-primary\"]");
    By EnterEmail_textBox = By.id("input-email");
    By EnterPassword_textBox = By.id("input-password");
    By LoginButton_textBox = By.cssSelector("input[class=\"btn btn-primary\"]");
    By MyAccountPage_textBox = By.xpath("(//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/account\"])[2]");

    public ChangePassPage MyAccount(){
         driver.findElement(MyAccount_textBox).click();
         return new ChangePassPage(driver);
    }

    public void MyAccountPage(){
        driver.findElement(MyAccountPage_textBox).click();
    }

    public ChangePassPage EnterLoginPage(){
        driver.findElement(LoginPage_textBox).click();
        return new ChangePassPage(driver);
    }

    public ChangePassPage EnterPasswordPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id=\"account-account\"]")));
        driver.findElement(PasswordPage_textBox).click();
        return new ChangePassPage(driver);
    }

    public ChangePassPage ChangePassword(String Pass_, String ConPass_){
        driver.findElement(Password_textBox).sendKeys(Pass_);
        driver.findElement(ConfirmPassword_textBox).sendKeys(ConPass_);
        return new ChangePassPage(driver);
    }

    public void ContinueButton(){
        driver.findElement(ContinueButton_textBox).click();
    }

    public void Login(String pass_){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"well\"]")));
        driver.findElement(EnterEmail_textBox).sendKeys("eprahimfathy@gmail.com");
        driver.findElement(EnterPassword_textBox).sendKeys(pass_);
        driver.findElement(LoginButton_textBox).click();
    }

}
