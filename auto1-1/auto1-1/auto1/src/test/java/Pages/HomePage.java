package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    //Web driver

    WebDriver driver;

    //Constructor

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    By search_Bar = By.name("search");
    By search_Icon = By.xpath("//*[@id=\"search\"]/span/button");
    By checkoutIcon = By.cssSelector("a[title=\"Checkout\"]"); // the checkout in the home page

    //Actions

    public void navigateToHomePage(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void validateSearchBarVisibility(){
        Assert.assertTrue(driver.findElement(search_Bar).isDisplayed());        //Check visibility of search bar
    }
    public void validateSubmitQueryClickingSearchIcon(){
        driver.findElement(search_Icon).click();        //Click on searchIcon
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=product/search"); //Validate navigation to Search Results page
    }
    public void validateSubmitQueryPressingEnter(){
        driver.findElement(search_Bar).sendKeys(Keys.ENTER);        //Pressing enter
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=product/search"); //Validate navigation to Search Results page
    }

    public SearchResults enterQuery(String query){
        driver.findElement(search_Bar).clear();
        driver.findElement(search_Bar).sendKeys(query, Keys.ENTER);
        return new SearchResults(driver);
    }

    public CheckoutPage navigateCheckout ()
    {
        driver.findElement(checkoutIcon).click();
        return new CheckoutPage(driver);
    }

}
