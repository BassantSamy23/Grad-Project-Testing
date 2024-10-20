package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.RegisterPage;


public class RegisterTests {
    WebDriver webDriver;
    RegisterPage registerPage;

    @BeforeTest
    public void OpenBrowser(){
        webDriver=new FirefoxDriver();
        webDriver.manage().window().maximize();
        registerPage=new RegisterPage(webDriver);
    }
    @Test
    public void register_with_All_Features_empty(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("");
        registerPage.lastName("");
        registerPage.email("");
        registerPage.telephone("");
        registerPage.password("");
        registerPage.confirm_password("");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.verify_that_user_entered_registerPage();
        registerPage.validate_error_msg_for_empty_firstname();
        registerPage.validate_error_msg_for_empty_lastname();
        registerPage.validate_error_msg_for_empty_email();
        registerPage.validate_error_msg_for_invalid_telephone();
        registerPage.validate_error_msg_for_invalid_password();
    }
    @Test
    public void register_with_not_agree_policy(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa7@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.submit();
        registerPage.validate_error_msg_for_not_agree_policy();
    }
    @Test
    public void register_with_incorrect_confirmed_password(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_incorrect_confirm_password();
    }

    @Test
    public void register_with_empty_firstName(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_empty_firstname();
    }
    @Test
    public void register_with_empty_lasttName(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("");
        registerPage.email("esraakhalyfa@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_empty_lastname();
    }
    @Test
    public void register_with_empty_email(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_empty_email();
    }
    @Test
    public void register_with_invalid_email(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        //registerPage.email("esraakhalyfa");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_invalid_email();
    }
    @Test
    public void register_with_empty_telephone(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa@gmail.com");
        registerPage.telephone("");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_invalid_telephone();
    }
    @Test
    public void register_with_empty_password(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_invalid_password();
    }

    @Test
    public void successful_register(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraaSkhalyfa@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_successful_register();
    }
    @Test
    public void register_with_EMail_Address_already_registered(){
        registerPage.navigate_to_register_page();
        registerPage.FirstName("esraa");
        registerPage.lastName("mohamed");
        registerPage.email("esraakhalyfa11@gmail.com");
        registerPage.telephone("1111111111");
        registerPage.password("11111");
        registerPage.confirm_password("11111");
        registerPage.agree_poicy();
        registerPage.submit();
        registerPage.validate_error_msg_for_emailAlready_registered();
    }

    @AfterTest
    public void close(){
        webDriver.close();
    }

}
