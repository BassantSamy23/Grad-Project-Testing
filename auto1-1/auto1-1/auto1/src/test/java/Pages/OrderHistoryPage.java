package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderHistoryPage {
    WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By orderHistory = By.xpath("//*[@id=\"column-right\"]/div/a[6]");
    By noOfProduct =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[3]");
    By total =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]");
    By customer =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]");
    By view_icon =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[7]/a");
    By paymentAddress =By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td[1]");
    By ShippingAddress=By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td[2]");
    By ProductName =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]");
    By ProductModel =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]");
    By return_icon =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a[2]");
    By reorder_icon =By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a[1]");




    public void navigate_to_orderhistory_page(){
        //driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        driver.findElement(orderHistory).click();
    }
    public void validate_order_history_page(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText().contains("Order History"));
    }
    public void validate_order_history_is_empty_first_time(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText().contains("You have not made any previous orders!"));
    }
    public void click_retrn(){
        driver.findElement(return_icon).click();
    }
    public void click_reorder(){
        driver.findElement(reorder_icon).click();
    }
    public void click_view(){
        driver.findElement(view_icon).click();
    }
    public void validate_that_item_reordered(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-order\"]/div[1]")).getText()
                .contains("Success: You have added"));
    }
    public void validate_that_item_returned(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText()
                .contains("Product Returns"));
    }
    //  //*[@id="content"]/h1
    public void validate_total_price(){
        Assert.assertTrue(driver.findElement(total).getText().contains("$106.00"));
    }
    public void validate_no_of_product(){
        Assert.assertTrue(driver.findElement(noOfProduct).getText().contains("1"));
    }
    public void validate_customer_name(){
        Assert.assertTrue(driver.findElement(customer).getText().contains("esraa mohamed"));
    }
    public void validate_product_name(){
        Assert.assertTrue(driver.findElement(ProductName).getText().contains("iPhone"));
    }
    public void validate_product_model(){
        Assert.assertTrue(driver.findElement(ProductModel).getText().contains("product 11"));
    }


}
