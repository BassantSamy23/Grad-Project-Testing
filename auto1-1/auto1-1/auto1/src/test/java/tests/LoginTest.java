package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {

        loginPage.login("m@m.com", "123456");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account"), "User should be redirected to the account page after a successful login.");

    }
    @Test
    public void testInvalidUsernamePassword() {
        // Test with invalid username and password
        loginPage.login("invalidUser@example.com", "invalidPassword");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-danger.alert-dismissible")));

        Assert.assertTrue(loginPage.isLoginErrorMessageVisible(), "Error message should be displayed.");
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");

    }
    @Test
    public void testValidUsernameInvalidPassword() {
        // Test with valid username and invalid password
        loginPage.login("m@m.com", "invalidPassword");

        Assert.assertTrue(loginPage.isLoginErrorMessageVisible(), "Error message should be displayed.");
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}