package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.OrderHistoryPage;
import Pages.RegisterPage;

import java.time.Duration;

public class OrderHistoryTest {
    WebDriver webDriver;
    OrderHistoryPage orderHistorypage;
    RegisterPage registerPage;
    LoginPage loginPage;
    @BeforeTest
    public void OpenBrowser(){
        webDriver=new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        orderHistorypage =new OrderHistoryPage(webDriver);
        registerPage=new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void testValidLogin() {

        loginPage.login("esraaMkhalyfa@gmail.com", "11111");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account"), "User should be redirected to the account page after a successful login.");

    }
    /*@Test
    public void validate_empty_orderhistory(){
        orderHistorypage.navigate_to_orderhistory_page();
        orderHistorypage.validate_order_history_page();
        orderHistorypage.validate_order_history_is_empty_first_time();
    }*/
    @Test
    public void validate_the_checkouted_order_in_historyOrder(){
        orderHistorypage.navigate_to_orderhistory_page();
        orderHistorypage.validate_order_history_page();
        orderHistorypage.validate_customer_name();
        orderHistorypage.validate_no_of_product();
        orderHistorypage.validate_total_price();
        orderHistorypage.click_view();
        orderHistorypage.validate_product_model();
        orderHistorypage.validate_product_name();
        orderHistorypage.click_reorder();
        orderHistorypage.validate_that_item_reordered();
        orderHistorypage.click_retrn();
        orderHistorypage.validate_that_item_returned();

    }

}
