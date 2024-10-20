package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NewAddressPage {

    //Web driver

    WebDriver driver;

    //Constructor


    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    By firstName_TextBox = By.id("input-firstname");
    By lastName_TextBox = By.id("input-lastname");
    By company_TextBox = By.id("input-company");
    By address1_TextBox = By.id("input-address-1");
    By address2_TextBox = By.id("input-address-2");
    By city_TextBox = By.id("input-city");
    By postCode_TextBox = By.id("input-postcode");
    By country_List = By.id("input-country");
    By state_List = By.id("input-zone");
    By stateList_Option1 = By.xpath("//*[@id=\"input-zone\"]/option[2]");
    By defaultAddress_CheckBox = By.xpath("//*[@id=\"content\"]/form/fieldset/div[10]/div/label[1]/input");
    By continue_Button = By.xpath("//input[@value=\"Continue\"]");

    //Actions

    public NewAddressPage enterFirstName(String firstName){
        driver.findElement(firstName_TextBox).sendKeys(firstName);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterLastName(String lastName){
        driver.findElement(lastName_TextBox).sendKeys(lastName);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterCompany(String company){
        driver.findElement(company_TextBox).sendKeys(company);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterAddress1(String address1){
        driver.findElement(address1_TextBox).sendKeys(address1);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterAddress2(String address2){
        driver.findElement(address2_TextBox).sendKeys(address2);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterCity(String city){
        driver.findElement(city_TextBox).sendKeys(city);
        return new NewAddressPage(driver);
    }
    public NewAddressPage enterPostCode(String postCode){
        driver.findElement(postCode_TextBox).sendKeys(postCode);
        return new NewAddressPage(driver);
    }
    public NewAddressPage selectCountry(String country){
        Select select = new Select(driver.findElement(country_List));
        select.selectByVisibleText(country);
        return new NewAddressPage(driver);
    }
    public NewAddressPage selectState(String state){
        try {    //Handle the state of that the country is United Kingdom, or it hasn't changed
            Select select = new Select(driver.findElement(state_List));
            select.selectByVisibleText(state);
        }
        catch (Exception e) {       //Handle all other states
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(stateList_Option1)));      //Indicate that state list has been updated successfully
            Select select = new Select(driver.findElement(state_List));
            select.selectByVisibleText(state);
        }
        return new NewAddressPage(driver);
    }
    public NewAddressPage selectDefaultAddress(){
        driver.findElement(defaultAddress_CheckBox).click();
        return new NewAddressPage(driver);
    }
    public AccountAddressPage clickContinue(){
        driver.findElement(continue_Button).click();
        return new AccountAddressPage(driver);
    }





}
