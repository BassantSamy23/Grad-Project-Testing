package tests.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
    //Web driver

    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        driver = new EdgeDriver();          //Using Microsoft Edge browser
        driver.manage().window().maximize();//Maximize window
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");       //Navigate to home page
    }
}
