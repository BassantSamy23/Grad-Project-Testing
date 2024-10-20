package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AccountAddressPage {

    //Web Driver

    WebDriver driver;

    //Constructor

    public AccountAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    By newAddress_Button = By.xpath("//*[@id=\"content\"]/div/div[2]/a");
    By addAddressSuccessfully_Label = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
    By addressData_table = By.xpath("//td[@class=\"text-left\"]");
    //Actions

    public  NewAddressPage clickNewAddress(){
        driver.findElement(newAddress_Button).click();
        return new NewAddressPage(driver);
    }
    public void validateAddAddress(){
        Assert.assertTrue(driver.findElement(addAddressSuccessfully_Label).getText().contains("Your address has been successfully added"));
    }
    public AccountAddressPage validateAddressName(String name, Integer index){
        boolean matchName = false;
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all address data
        WebElement addressData = addressesData.get(index);
        if (addressData.getText().split("\n")[0].equals(name)){
            matchName = true;
        }
        Assert.assertTrue(matchName, "No name matches");
        return new AccountAddressPage(driver);
    }
    public AccountAddressPage validateAddressCompany(String company, Integer index){
        boolean matchCompany = false;
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all address data
        WebElement addressData = addressesData.get(index);
        if (addressData.getText().split("\n")[1].equals(company)){
                matchCompany = true;
        }
        Assert.assertTrue(matchCompany, "No company matches");
        return new AccountAddressPage(driver);
    }
    public Integer validateAddress1And2(String address){
        boolean matchAddress = false;
        Integer index = 0;                  //Index of the table that contain the match address
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all addresses name
        for (WebElement addressData : addressesData){
            if (addressData.getText().split("\n")[2].equals(address.split("\n")[0]) && addressData.getText().split("\n")[3].equals(address.split("\n")[1]) ){
                matchAddress = true;
                break;
            }
            else{
                index++;
            }
        }
        Assert.assertTrue(matchAddress, "No address matches");
        return index;
    }
    public AccountAddressPage validateAddressCity(String cityInfo, Integer index){
        boolean matchCity = false;
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all address data
        WebElement addressData = addressesData.get(index);
        if (addressData.getText().split("\n")[4].equals(cityInfo)){
            matchCity = true;
        }
        Assert.assertTrue(matchCity, "No company matches");
        return new AccountAddressPage(driver);
    }
    public AccountAddressPage validateAddressState(String state, Integer index){
        boolean matchState = false;
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all address data
        WebElement addressData = addressesData.get(index);
        if (addressData.getText().split("\n")[5].equals(state)){
            matchState = true;
        }
        Assert.assertTrue(matchState, "No state matches");
        return new AccountAddressPage(driver);
    }
    public AccountAddressPage validateAddressCountry(String country, Integer index){
        boolean matchCountry = false;
        List<WebElement> addressesData = driver.findElements(addressData_table);        //Collect all address data
        WebElement addressData = addressesData.get(index);
        if (addressData.getText().split("\n")[6].equals(country)){
            matchCountry = true;
        }
        Assert.assertTrue(matchCountry, "No company matches");
        return new AccountAddressPage(driver);
    }
}
