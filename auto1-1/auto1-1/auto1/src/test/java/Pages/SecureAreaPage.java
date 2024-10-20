package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SecureAreaPage {
    WebDriver driver;


    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    By HomePage_textBox = By.id("content");
    By ShoppingPage_textBox = By.cssSelector("div[class=\"col-sm-12\"]");
    By MessageShoppingPage_textBox = By.cssSelector("div[class=\"alert alert-danger alert-dismissible\"]");

    By ProductName_textBox = By.cssSelector("td[class=\"text-left\"]");

    By UploadErrorMessage_txt = By.cssSelector("div[class=\"text-danger\"]");
    By NotAvailableErrorMessage_txt = By.cssSelector("div[class=\"alert alert-danger alert-dismissible\"]");
    By QuaElement_txt = By.cssSelector("input[size=\"1\"]");
    By ShippingFlatRate_txt = By.className("modal-title");

    By ChangePass_txt = By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]");
    By InvalidPass_txt = By.cssSelector("div[class=\"text-danger\"]");

    By EditMessage_txt = By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]");
    By EditErrorMessage_txt = By.cssSelector("div[class=\"text-danger\"]");


    public boolean HomePage(){
           return driver.findElement(HomePage_textBox).getText()
                   .contains("Featured");
    }

    public boolean ShoppingPage(String Text_){
         return driver.findElement(ShoppingPage_textBox).getText()
                .contains(Text_);
    }
    public boolean MessageShoppingPage(String Text_){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(MessageShoppingPage_textBox).getText()
                .contains(Text_);
    }
    public boolean ProductName(String Text_){
        return driver.findElement(ProductName_textBox).getText()
                .contains(Text_);
    }
    public String ProductQua(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(QuaElement_txt).getText();
    }

    public boolean ValidateErrorMessage(String Text_){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(UploadErrorMessage_txt));
        return driver.findElement(UploadErrorMessage_txt).getText()
            .contains(Text_);
    }
    public boolean NotAvailableErrorMessage(){
        return driver.findElement(NotAvailableErrorMessage_txt).getText()
                .contains("Products marked with *** are not available in the desired quantity or not in stock!");
    }
    public boolean ShippingFlatRate(){
        return driver.findElement(ShippingFlatRate_txt).getText()
                .contains("Please select the preferred shipping method to use on this order.");
    }

    public boolean ChangePass(){
        return driver.findElement(ChangePass_txt).getText()
                .contains("Success: Your password has been successfully updated.");
    }

    public boolean EditAccountMessage(){
        return driver.findElement(EditMessage_txt).getText()
                .contains("Success: Your account has been successfully updated.");
    }
    public boolean EditErrorTermMessage(String message){
        return driver.findElement(EditErrorMessage_txt).getText()
                .contains(message);
    }

    public boolean InvalidPassword(){
        return driver.findElement(InvalidPass_txt).getText()
                .contains("Password must be between 4 and 20 characters!");
    }

    public boolean InvalidConfirmPassword(){
        return driver.findElement(InvalidPass_txt).getText()
                .contains("Password confirmation does not match password!");
    }
}
