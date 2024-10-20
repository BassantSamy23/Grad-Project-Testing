package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class RegisterPage {

    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // elements
    By First_Name_textbox =By.id("input-firstname");
    By Last_Name_textbox =By.id("input-lastname");
    By EMail_textbox =By.id("input-email");
    By Telephone_textbox =By.id("input-telephone");
    By Password_textbox =By.id("input-password");
    By Confirm_password_textbox =By.id("input-confirm");
    By continue_button =By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    By agreePolicy_checkbox =By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");

    //methods

    public void navigate_to_register_page (){
        webDriver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        //Locate the dropdown element
        webDriver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        //account.selectByVisibleText("Register");
    }
    public void verify_that_user_entered_registerPage()
    {
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).isDisplayed());

    }
    public void FirstName(String firstname){
        webDriver.findElement(First_Name_textbox).sendKeys(firstname);
    }
    public void lastName(String lastname){
        webDriver.findElement(Last_Name_textbox).sendKeys(lastname);
    }
    public void email(String mail){
        webDriver.findElement(EMail_textbox).sendKeys(mail);
    }
    public void telephone(String phone){
        webDriver.findElement(Telephone_textbox).sendKeys(phone);
    }
    public void password(String password){
        webDriver.findElement(Password_textbox).sendKeys(password);
    }
    public void confirm_password(String confirmed_password){
        webDriver.findElement(Confirm_password_textbox).sendKeys(confirmed_password);
    }
    public void agree_poicy (){
        webDriver.findElement(agreePolicy_checkbox).click();
    }
    public void submit(){
        webDriver.findElement(continue_button).click();
    }
    public void validate_error_msg_for_empty_firstname(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText().contains("First Name must be between 1 and 32 characters"));
    }
    public void validate_error_msg_for_empty_lastname(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText().contains("Last Name must be between 1 and 32 characters"));
    }
    public void validate_error_msg_for_empty_email(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText().contains("E-Mail Address does not appear to be valid!"));
    }
    public void validate_error_msg_for_invalid_email(){
        WebElement emailField = webDriver.findElement(By.id("input-email"));
        emailField.sendKeys("amr");
        emailField.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep exception");
        }
        String message = emailField.getAttribute("validationMessage");
        System.out.println(message);
    }
    public void validate_error_msg_for_invalid_telephone(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText().contains("Telephone must be between 3 and 32 characters!"));
    }
    public void validate_error_msg_for_invalid_password(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText().contains("Password must be between 4 and 20 characters!"));
    }
    public void validate_error_msg_for_incorrect_confirm_password(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")).getText().contains("Password confirmation does not match password!"));
    }
    public void validate_error_msg_for_not_agree_policy(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText().contains("You must agree to the Privacy Policy!"));
    }
    public void validate_successful_register(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Your Account Has Been Created!"));
    }
    public void validate_error_msg_for_emailAlready_registered(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText().contains("E-Mail Address is already registered!"));
    }




}

