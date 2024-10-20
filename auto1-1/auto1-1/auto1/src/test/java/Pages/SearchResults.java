package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResults {

    //Web driver

    WebDriver driver;

    //Constructor


    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By search_Bar = By.name("search");
    By product_Title = By.tagName("h4");
    By search_Label = By.tagName("h1");
    By numberOfResults_Label = By.xpath("//div[@class=\"col-sm-6 text-right\"]");
    By category_List = By.name("category_id");
    By search_Button = By.id("button-search");
    By sorting_list = By.id("input-sort");
    By price_Text = By.xpath("//p[@class=\"price\"]");
    By description_Text = By.xpath("//*[@id=\"content\"]/div[3]/div[*]/div/div[2]/div[1]/p[1]");
    By searchByDescription_Checkbox = By.id("description");
    By noProducts_Label = By.xpath("//*[@id=\"content\"]/p[2]");

    //Actions

    public SearchResults enterQuery(String query){
        driver.findElement(search_Bar).clear();
        driver.findElement(search_Bar).sendKeys(query, Keys.ENTER);
        return new SearchResults(driver);
    }
    public void validateSearchResults(String query){
        Assert.assertEquals(driver.findElement(search_Label).getText(),"Search - " + query);    //Validate search label
        List<WebElement> searchResultsTitle = driver.findElements(product_Title);      //Get the title of all products in search result
        for (WebElement title : searchResultsTitle) {

            Assert.assertTrue(title.getText().toLowerCase().contains(query.toLowerCase()));
        }
        Assert.assertTrue(driver.findElement(numberOfResults_Label).getText().contains("of " + searchResultsTitle.size())); //Validate number of results
    }
    public SearchResults selectCategory(String category){
        Select select = new Select(driver.findElement(category_List));
        select.selectByVisibleText(category);
        driver.findElement(search_Button).click();
        return new SearchResults(driver);
    }
    public void validateMp3PlayerCategorization(){
        boolean matchFound = false;
        List<WebElement> searchProducts = driver.findElements(product_Title);   //Collect all search result products
        List<String> searchProductsTitle = new ArrayList<>();
        for (WebElement searchProduct : searchProducts){
            searchProductsTitle.add(searchProduct.getText());                              //Collect all products title
        }
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=34");  //Navigate to Mp3 player category
        List<WebElement> categoryProductsTitle = driver.findElements(product_Title);        //Collect all products title
        for (String searchProductTitle : searchProductsTitle){
            matchFound = false;                                               //No matching until now
            for (WebElement categoryProductTitle : categoryProductsTitle){
                if (searchProductTitle.equals(categoryProductTitle.getText())){
                    matchFound = true;                                               //There is a matching
                    break;
                }
            }
        }
        Assert.assertTrue(matchFound);
    }
    public void validateCamerasCategorization(){
        boolean matchFound = false;
        List<WebElement> searchProducts = driver.findElements(product_Title);   //Collect all search result products
        List<String> searchProductsTitle = new ArrayList<>();
        for (WebElement searchProduct : searchProducts){
            searchProductsTitle.add(searchProduct.getText());                              //Collect all products title
        }
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=product/category&path=33");  //Navigate to Mp3 player category
        List<WebElement> categoryProductsTitle = driver.findElements(product_Title);        //Collect all products title
        for (String searchProductTitle : searchProductsTitle){
            matchFound = false;                                               //No matching until now
            for (WebElement categoryProductTitle : categoryProductsTitle){
                if (searchProductTitle.equals(categoryProductTitle.getText())){
                    matchFound = true;                                               //There is a matching
                    break;
                }
            }
        }
        Assert.assertTrue(matchFound);
    }
    public SearchResults sortBy(String sortingOption){
        Select select = new Select(driver.findElement(sorting_list));       //Select options in Sorting list
        select.selectByVisibleText(sortingOption);                          //Select option
        return new SearchResults(driver);
    }
    public SearchResults validateSortingLowestPrice(){
        List <WebElement> productPrices = driver.findElements(price_Text); //Select all prices
        List <Double> prices = new ArrayList<>();
        for (WebElement productPrice : productPrices){
            prices.add(Double.parseDouble(productPrice.getText().split("\n")[0].replace("$", "").replace(",", "").split(" ")[0]));
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);             //Sort the prices in ascending order
        Assert.assertEquals(prices, sortedPrices);
        return new SearchResults(driver);
    }
    public void validateSearchByDescription(String query){
        Assert.assertEquals(driver.findElement(search_Label).getText(),"Search - " + query);    //Validate search label
        List<WebElement> productsDescription = driver.findElements(description_Text);      //Get the description of all products in search result
        for (WebElement productDescription : productsDescription) {
            Assert.assertTrue(productDescription.getText().toLowerCase().contains(query.toLowerCase()));
        }
        Assert.assertTrue(driver.findElement(numberOfResults_Label).getText().contains("of " + productsDescription.size())); //Validate number of results
    }
    public SearchResults selectSearchByDescription(){
        driver.findElement(searchByDescription_Checkbox).click();
        driver.findElement(search_Button).click();
        return new SearchResults(driver);
    }
    public void validateNoProductsMessage(){
        Assert.assertEquals(driver.findElement(noProducts_Label).getText(), "There is no product that matches the search criteria.");
    }
    public void validateSortingByName_A(){
        List<String>  titles = new ArrayList<>();
        List<WebElement> searchResultsTitle = driver.findElements(product_Title);      //Get the title of all products in search result
        for (WebElement title : searchResultsTitle) {
            titles.add(title.getText().toLowerCase());
        }
        List<String> sortedTitles = new ArrayList<>(titles);
        Collections.sort(sortedTitles);
        System.out.println(titles);
        System.out.println(sortedTitles);
        Assert.assertEquals(titles, sortedTitles);

    }
    public void search(String query) {
        enterQuery(query);
        //validateSearchResults(query);
    }
}
