package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class EditAccountPage {
    WebDriver driver;


    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By EditAccPage_textBox = By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/edit\"]");
    By EditFirstName_textBox = By.id("input-firstname");
    By EditLastnameName_textBox = By.id("input-lastname");
    By EditEmailName_textBox = By.id("input-email");
    By EditTelephoneName_textBox = By.id("input-telephone");

    public EditAccountPage EnterEditPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(EditAccPage_textBox));
        driver.findElement(EditAccPage_textBox).click();
        return new EditAccountPage(driver);
    }

    public EditAccountPage EnterEditFirstName(String FirstName){
        driver.findElement(EditFirstName_textBox).clear();
        driver.findElement(EditFirstName_textBox).sendKeys(FirstName);
        return new EditAccountPage(driver);
    }
    public EditAccountPage EnterEditLastName(String LastName){
        driver.findElement(EditLastnameName_textBox).clear();
        driver.findElement(EditLastnameName_textBox).sendKeys(LastName);
        return new EditAccountPage(driver);
    }
    public EditAccountPage EnterEditEmail(String Email){
        driver.findElement(EditEmailName_textBox).clear();
        driver.findElement(EditEmailName_textBox).sendKeys(Email);
        return new EditAccountPage(driver);
    }
    public EditAccountPage EnterEditTelephone(String Telephone){
        driver.findElement(EditTelephoneName_textBox).clear();
        driver.findElement(EditTelephoneName_textBox).sendKeys(Telephone);
        return new EditAccountPage(driver);
    }

    public void ValidateErrorMessage(){
        // Assuming the error message is within a div with class "error-message"
        WebElement errorContainer = driver.findElement(By.cssSelector("Pleas enter an email address."));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String errorMessage = (String) executor.executeScript("return arguments[0].textContent;", errorContainer);

        // Assert the error message
        assertEquals("Pleas enter an email address.", errorMessage);
    }



}
