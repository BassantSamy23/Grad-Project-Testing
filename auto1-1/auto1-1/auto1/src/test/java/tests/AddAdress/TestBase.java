package tests.AddAdress;

import Pages.AccountPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {

    WebDriver driver;

    LoginPage loginPage;
    AccountPage accountPage;

    //Variables

    String firstName = "Ahmed";
    String lastName = "Lotfy";
    String company = "Amit";
    String address1 = "Ahmed Maher, Khalifa St";
    String address2 = "Building2, Apartment1";
    String city = "Mansoura";
    String postCode = "+20";
    String country = "Egypt";
    String state = "Ad Daqahliyah";

    @BeforeClass
    public void openBrowser(){
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");           //Navigate to Login page
        loginPage.login("a0@gmail.com", "1234");
        accountPage.ClickModifyBooKEntries();
    }
}
