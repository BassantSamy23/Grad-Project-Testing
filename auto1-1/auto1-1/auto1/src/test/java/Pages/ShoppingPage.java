package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage {
    WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String productName;

    By shoppingButton_txt = By.cssSelector("a[title=\"Shopping Cart\"]");
    By Product1Button_txt = By.cssSelector("button[onclick=\"cart.add('43');\"]");
    By Product2Button_txt = By.cssSelector("button[onclick=\"cart.add('40');\"]");
    By Product2SeaButton_txt = By.cssSelector("button[onclick=\"cart.add('40', '1');\"]");
    By Product3Button_txt = By.cssSelector("button[onclick=\"cart.add('49', '1');\"]");
    By Apple_CProduct_txt = By.cssSelector("button[onclick=\"cart.add('42');\"]");

    By Product1Name_txt = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=product/product&product_id=43\"]");
    By Product2Name_txt = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=product/product&product_id=40\"]");
    By TabletsBar_txt = By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=product/category&path=57\"]");

    By ContinueShButton_txt = By.cssSelector("a[class=\"btn btn-default\"]");

    By SizesSlc_txt = By.cssSelector("input[name=\"option[218]\"]");
    By CheckboxSlc_txt = By.cssSelector("input[name=\"option[223][]\"]");
    By ColorSlc_txt = By.xpath("//select[@class=\"form-control\"]/option[@value='4']");
    By TextareaSlc_txt = By.xpath("//textarea[@placeholder=\"Textarea\"]");
    By UploadFile_txt = By.id("button-upload222");
    By ButtonCart_txt = By.xpath("//button[@id=\"button-cart\"]");

    By QuaElement_txt = By.cssSelector("input[size=\"1\"]");
    By UpdateQuaButton_txt = By.cssSelector("button[class=\"btn btn-primary\"]");
    By InputQua_txt = By.id("input-quantity");

    By ShippingEstimate_txt = By.cssSelector("a[href=\"#collapse-shipping\"]");
    By ShippingCountry_txt = By.xpath("//select[@id=\"input-country\"]/option[@value='63']");
    By ShippingState_txt = By.xpath("//select[@id=\"input-zone\"]/option[@value='1004']");
    By ShippingPostCode_txt = By.xpath("//input[@id=\"input-postcode\"]");
    By ShippingButton_txt = By.id("button-quote");
    By FlatShippingScl_txt = By.cssSelector("input[name=\"shipping_method\"]");
    By ApplyShippingButton_txt = By.id("button-shipping");

    By CouponCode_txt = By.cssSelector("a[href=\"#collapse-coupon\"]");
    By EnterCouponCode_txt = By.xpath("//input[@id=\"input-coupon\"]");
    By CouponButton_txt = By.id("button-coupon");

    By CertificateCode_txt = By.cssSelector("a[href=\"#collapse-voucher\"]");
    By EnterCertificateCode_txt = By.xpath("//input[@id=\"input-voucher\"]");
    By CertificateButton_txt = By.id("button-voucher");


    /**
     *
     * */
    public ShoppingPage Navigate(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        return new ShoppingPage(driver);
    }
    /**
     *
     * */
    public ShoppingPage shoppingButton() {
        driver.findElement(shoppingButton_txt).click();
        return new ShoppingPage(driver);
    }
    /**
     *
     * */
    public ShoppingPage Product1() {
        productName = driver.findElement(Product1Name_txt).getText();
        driver.findElement(Product1Button_txt).click();
        return new ShoppingPage(driver);
    }
    /**
     *
     * */
    public WebElement ProductPage1(String Name_) {
        productName = driver.findElement(Product1Name_txt).getText();
        return driver.findElement(By.cssSelector("img[alt="+ Name_ +"]"));
    }
    /**
     *
     * */
    public void InputQuantity(String Qua_) {
        productName = driver.findElement(Product1Name_txt).getText();
        driver.findElement(InputQua_txt).clear();
        driver.findElement(InputQua_txt).sendKeys(Qua_);
    }
    /**
     *
     * */
    public ShoppingPage Product2() {
        productName = driver.findElement(Product2Name_txt).getText();
        driver.findElement(Product2Button_txt).click();
        return new ShoppingPage(driver);
    }

    public ShoppingPage Product2Sea() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"col-sm-12\"]")));
        driver.findElement(Product2SeaButton_txt).click();
        return new ShoppingPage(driver);
    }
    /**
     *
     * */
    public WebElement Product3() {
        return driver.findElement(Product3Button_txt);
    }
    public ShoppingPage Apple_CProduct() {
        driver.findElement(Apple_CProduct_txt).click();
        return new ShoppingPage(driver);
    }
    public ShoppingPage TabletsBar() {
        driver.findElement(TabletsBar_txt).click();
        return new ShoppingPage(driver);
    }
    public WebElement ContinueShButton() {
        return driver.findElement(ContinueShButton_txt);
    }
    /**
     *
     * */
    public void OptionsSlc(String TextArea_) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"option[218]\"]")));
        driver.findElement(SizesSlc_txt).click();
        driver.findElement(CheckboxSlc_txt).click();
        driver.findElement(ColorSlc_txt).click();
        driver.findElement(TextareaSlc_txt).sendKeys(TextArea_);
//        WebElement uploadElement = driver.findElement(UploadFile_txt);
//        String filePath = "C:\\Users\\Ts\\Desktop\\Ibrahim_Fathy.pdf";
//
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].style.display = 'block';", uploadElement);
//        executor.executeScript("arguments[0].value = '" + filePath + "';", uploadElement);

 //       driver.findElement(UploadFile_txt).sendKeys("C:\\Users\\Ts\\Desktop\\Ibrahim_Fathy.pdf");
    }
    /**
     *
     * */
    public void OptionsNoCheckboxSlc(String TextArea_) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"option[218]\"]")));
        driver.findElement(SizesSlc_txt).click();
        driver.findElement(ColorSlc_txt).click();
        driver.findElement(TextareaSlc_txt).sendKeys(TextArea_);
        driver.findElement(UploadFile_txt);
    }
    /**
     *
     * */
    public void OptionsNoRadioSlc(String TextArea_) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"option[218]\"]")));
        driver.findElement(CheckboxSlc_txt).click();
        driver.findElement(ColorSlc_txt).click();
        driver.findElement(TextareaSlc_txt).sendKeys(TextArea_);
        driver.findElement(UploadFile_txt);
    }
    /**
     *
     * */
    public void OptionsNoColorSlc(String TextArea_) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name=\"option[218]\"]")));
        driver.findElement(CheckboxSlc_txt).click();
        driver.findElement(SizesSlc_txt).click();
        driver.findElement(TextareaSlc_txt).sendKeys(TextArea_);
        driver.findElement(UploadFile_txt);
    }
    /**
     *
     * */
    public ShoppingPage ButtonCart() {
         driver.findElement(ButtonCart_txt).click();
         return new ShoppingPage(driver);
    }
    /**
     *
     * */
    public void EmptyProduct_Qua(){
        driver.findElement(QuaElement_txt).clear();
        driver.findElement(UpdateQuaButton_txt).click();
    }
    /**
     *
     * */
    public void UpdateProduct_Qua(String Qua_){
        driver.findElement(QuaElement_txt).clear();
        driver.findElement(QuaElement_txt).sendKeys(Qua_);
        driver.findElement(UpdateQuaButton_txt).click();
    }
    /**
     *
     * */
    public void ShippingEstimate(){
        driver.findElement(ShippingEstimate_txt).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(ShippingCountry_txt));
        driver.findElement(ShippingCountry_txt).click();
        wait.until(ExpectedConditions.elementToBeClickable(ShippingState_txt));
        driver.findElement(ShippingState_txt).click();
        driver.findElement(ShippingPostCode_txt).sendKeys("5689");
        driver.findElement(ShippingButton_txt).click();
        wait.until(ExpectedConditions.elementToBeClickable(FlatShippingScl_txt));
        driver.findElement(FlatShippingScl_txt).click();
        driver.findElement(ApplyShippingButton_txt).click();
    }

    public void CouponCode(String Code_){
        driver.findElement(CouponCode_txt).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(EnterCouponCode_txt).sendKeys(Code_);
        driver.findElement(CouponButton_txt).click();
    }

    public void CertificateCode(String Code_){
        driver.findElement(CertificateCode_txt).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(EnterCertificateCode_txt).sendKeys(Code_);
        driver.findElement(CertificateButton_txt).click();
    }
}
