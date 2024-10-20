package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    //Web driver

    WebDriver driver;

    //Constructor

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators

    By modifyBookEntries_Button = By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a");

    //Actions

    public void ClickModifyBooKEntries(){
        driver.findElement(modifyBookEntries_Button).click();
    }
}
