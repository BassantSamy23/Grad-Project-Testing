package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutIcon = By.id("content"); // to verify the checkout page appears
    By billingDetailsPage = By.cssSelector("form[class=\"form-horizontal\"]");
    By addressFirstNameTextBox = By.id("input-payment-firstname");
    By addressLastNameTextBox  = By.id("input-payment-lastname");
    By address1TextBox = By.id("input-payment-address-1");
    By address2TextBox = By.id("input-payment-address-2");
    By addressCityTextBox = By.id("input-payment-city");
    By addressPostCode = By.id("input-payment-postcode");
    By addressCountryDropDown = By.id("input-payment-country");
    By addressRegionDropDown = By.id("input-payment-zone");
    By billingContinue = By.id("button-payment-address");
    By nameFieldsErrorMessage =By.xpath("(//div[@class='text-danger'])[1]");
    By existingAddressDropDown = By.xpath("(//select[@name='address_id' and @class='form-control'])[2]");
    By deliveryDetailsStep = By.cssSelector("#accordion > div:nth-child(3) > div.panel-heading > h4 > a > i");
    By newAddressRadio = By.xpath("(//input[@type='radio' and @value='new'])[2]");
    By newAddressFirstNameTextBox = By.id("input-shipping-firstname");// when choosing the new address
    By newAddressLastNameTextBox  = By.id("input-shipping-lastname");
    By newAddress1TextBox = By.id("input-shipping-address-1");
    By newAddress2TextBox = By.id("input-shipping-address-2");
    By newAddressCityTextBox = By.id("input-shipping-city");
    By newAddressPostCode = By.id("input-shipping-postcode");
    By newAddressCountryDropDown = By.id("input-shipping-country");
    By newAddressRegionDropDown = By.id("input-shipping-zone");
    By deliveryDetailsContinue = By.id("button-shipping-address");
    By deliveryMethodStep = By.xpath("//p[contains(text(),\"Please select the preferred shipping method to use on this order.\")]"); // check that it's expanded with the attribute didn't work
    By shippingRateRadio = By.cssSelector("input[value=\"flat.flat\"]");
    By commentTextArea= By.cssSelector("textarea[name=\"comment\"]");
    By deliveryMethodContinue = By.id("button-shipping-method");
    By paymentMethodStep = By.xpath("//p[contains(text(),\"Please select the preferred payment method to use on this order.\")]"); // to go back fo the step for more testcases
    By paymentMethodRadio= By.cssSelector("input[value=\"cod\"]");
    By termsAndCondCheckBox = By.cssSelector("input[name=\"agree\"]");
    By paymentContinueButton = By.id("button-payment-method");
    By termsAndConditionErrorMSG = By.cssSelector("div[class=\"alert alert-danger alert-dismissible\"]");
    By confirmOrderStep = By.cssSelector("div[class=\"table-responsive\"]");// check if the table appears in the step
    By product1 = By.xpath("(//td[@class='text-left'])[5]");
    By product2 = By.xpath("(//td[@class='text-left'])[7]");
    By quantity1 = By.xpath("(//td[@class='text-right'])[14]");
    By quantity2 = By.xpath("(//td[@class='text-right'])[17]");
    By unitPriceProduct1 = By.xpath("(//td[@class='text-right'])[15]");
    By unitPriceProduct2 = By.xpath("(//td[@class='text-right'])[18]");
    By totalPriceProduct1 = By.xpath("(//td[@class='text-right'])[19]");
    By totalPriceProduct2 = By.xpath("(//td[@class='text-right'])[16]");
    By flatShippingRate =By.xpath("(//td[@class='text-right'])[23]");
    By confirmOrderButton =By.cssSelector("input[value=\"Confirm Order\"]");
    By successConfirmOrderMSG = By.xpath("//h1[contains(text(),\"Your order has been placed!\")]");
    By continueToTheHomePage = By.cssSelector("a[class=\"btn btn-primary\"]");
    By homePageIcon = By.cssSelector("img[class=\"img-responsive\"]");
    By billingAddress_List = By.xpath("//*[@id=\"payment-existing\"]/select");
    By deliveryAddress_List = By.xpath("//*[@id=\"shipping-existing\"]/select");



    //to verify that it takes you to the checkoutpage
    public CheckoutPage checkoutPageAppearance ()
    {
        Assert.assertTrue(driver.findElement(checkoutIcon).isDisplayed());
        return new CheckoutPage(driver);
    }
    // if you're already logged in you should be in the billing details step

    //verify the appearance of the billing detail step
    public CheckoutPage billingDetailsStepAppearance ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[class=\"form-horizontal\"]")));
        Assert.assertTrue(driver.findElement(billingDetailsPage).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage EnterDataForTheAddress(String firstName,String lastName , String address1 , String address2, String city , String postalCode)
    {
        driver.findElement(addressFirstNameTextBox).clear();
        driver.findElement(addressFirstNameTextBox).sendKeys(firstName);
        driver.findElement(addressLastNameTextBox).sendKeys(lastName);
        driver.findElement(address1TextBox).sendKeys(address1);
        driver.findElement(address2TextBox).sendKeys(address2);
        driver.findElement(addressCityTextBox).sendKeys(city);
        driver.findElement(addressPostCode).sendKeys(postalCode);

        Select selectCountry =new Select(driver.findElement(addressCountryDropDown));
        Select selectRegion = new Select(driver.findElement(addressRegionDropDown));

        selectCountry.selectByVisibleText("Egypt");
        selectRegion.selectByIndex(1);
        driver.findElement(billingContinue).click();
        return new CheckoutPage(driver);
    }
    //when you exceed the max limit of chars or enter empty field
    public CheckoutPage verifyErrorMessageDisplayedforinvalidData()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldsErrorMessage));
        Assert.assertTrue(driver.findElement(nameFieldsErrorMessage).isDisplayed());
        return new CheckoutPage(driver);
    }

    // check the existing address is the address you entered
    public CheckoutPage verifyExistingAddressIsTheAddressYouEntered ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(existingAddressDropDown));
        Select selectAddress = new Select(driver.findElement(existingAddressDropDown));
        String address= selectAddress.getOptions().get(0).getText();
        Assert.assertTrue(address.contains("AinShams1"));
        return new CheckoutPage(driver);
    }
    //check that the existing address
    public CheckoutPage userChooseExistingAddress()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(existingAddressDropDown));
        Select selectAddress = new Select(driver.findElement(existingAddressDropDown));
        selectAddress.selectByIndex(0);
        driver.findElement(deliveryDetailsContinue).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage userChooseEnteringNewAddress()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryDetailsStep));
        driver.findElement(deliveryDetailsStep).click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(newAddressRadio));
        driver.findElement(newAddressRadio).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage enterNewAddress(String firstName,String lastName , String address1 , String address2, String city , String postalCode)
    {
        driver.findElement(newAddressFirstNameTextBox).sendKeys(firstName);
        driver.findElement(newAddressLastNameTextBox).sendKeys(lastName);
        driver.findElement(newAddress1TextBox).sendKeys(address1);
        driver.findElement(newAddress2TextBox).sendKeys(address2);
        driver.findElement(newAddressCityTextBox).sendKeys(city);
        driver.findElement(newAddressPostCode).sendKeys(postalCode);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(newAddressCountryDropDown));
        Select selectCountry =new Select(driver.findElement(newAddressCountryDropDown));
        Select selectRegion = new Select(driver.findElement(newAddressRegionDropDown));

        selectCountry.selectByVisibleText("Egypt");
        selectRegion.selectByIndex(4);
        driver.findElement(deliveryDetailsContinue).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyMovingToDeliveryMethodSuccessfullyAfterContinue ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryMethodStep));
        Assert.assertTrue(driver.findElement(deliveryMethodStep).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyFlatRateIsCheckedByDefault ()
    {
        Assert.assertTrue(driver.findElement(shippingRateRadio).isSelected());
        return new CheckoutPage(driver);
    }
    public CheckoutPage userEnterComment (String comment)
    {
        driver.findElement(commentTextArea).sendKeys(comment);
        return new CheckoutPage(driver);
    }
    public CheckoutPage verifyMovingToPaymentMethodSuccessfullyAfterContinue()
    {
        driver.findElement(deliveryMethodContinue).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethodStep));
        Assert.assertTrue(driver.findElement(paymentMethodStep).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyPaymentMethodRadioIsCheckedByDefault ()
    {
        Assert.assertTrue((driver.findElement(paymentMethodRadio)).isSelected());
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkTheTermsAndConditionBox()
    {
        driver.findElement(termsAndCondCheckBox).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickingOnContinue()
    {
        driver.findElement(paymentContinueButton).click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyErrorMSGDisplayedWhenTheBoxNotChecked ()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionErrorMSG));
        Assert.assertTrue(driver.findElement(termsAndConditionErrorMSG).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyMovingToTheConfirmOrderAfterContinue()
    {
        //Assert.assertEquals(driver.findElement(confirmOrderStep).getAttribute("aria-expanded"),"true"); didn't work
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderStep));
        Assert.assertTrue(driver.findElement(confirmOrderStep).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyTheProductIsTheSameYouPurchased (String prod1,String prod2)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(product1));
        Assert.assertTrue(driver.findElement(product1).getText().contains(prod1));
        Assert.assertTrue(driver.findElement(product2).getText().contains(prod2));
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyTheQuantityOfProductsIsDiplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantity1));
        Assert.assertTrue(driver.findElement(quantity1).isDisplayed());
        Assert.assertTrue(driver.findElement(quantity2).isDisplayed());
        return new CheckoutPage(driver);
    }
    public CheckoutPage verifyThePriceOfProductIsDiplayed()
    {
        Assert.assertTrue(driver.findElement(unitPriceProduct1).isDisplayed());
        Assert.assertTrue(driver.findElement(unitPriceProduct2).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyTheTotalPriceOfProductsIsDiplayed ()
    {
        Assert.assertTrue(driver.findElement(totalPriceProduct1).isDisplayed());
        Assert.assertTrue(driver.findElement(totalPriceProduct2).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifyTheShippingFeesIsDiplayed()
    {
        Assert.assertTrue(driver.findElement(flatShippingRate).isDisplayed());
        return new CheckoutPage(driver);
    }

    public CheckoutPage verifySuccessMSGWhenUserConfirmTheOrder ()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successConfirmOrderMSG));
        Assert.assertTrue(driver.findElement(successConfirmOrderMSG).getText().contains("Your order has been placed!"));
        return new CheckoutPage(driver);
    }

    public HomePage verifyTheUserGoesToTheHomePageAfterClickingContinue()
    {
        driver.findElement(continueToTheHomePage).click();
        Assert.assertTrue(driver.findElement(homePageIcon).isDisplayed());
        return new HomePage(driver);
    }

    public CheckoutPage chooseExistingAddressinBillingDetails ()
    {
        driver.findElement(By.id("button-payment-address")).click();
        return new CheckoutPage(driver);
    }
    public void validateAddressData(String name, String address, String cityInfo, String state, String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(billingAddress_List));
        Select select = new Select(driver.findElement(billingAddress_List));
        List<WebElement> addressesData = select.getOptions();  //Collect all addresses data
        boolean matchFound = false;
        for (WebElement addressData : addressesData){                           //validate the new address matches an address in the list
            if (addressData.getText().equals(name + ", " + address + ", " + cityInfo + ", " + state + ", " + country)){
                matchFound = true;                          //There is an address that matches the new address
                break;
            }
        }
        Assert.assertTrue(matchFound);
        driver.findElement(billingContinue).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(deliveryAddress_List));
        Select select1 = new Select(driver.findElement(deliveryAddress_List));
        List<WebElement> addressesData1 = select1.getOptions();  //Collect all addresses data
        boolean matchFound1 = false;
        for (WebElement addressData1 : addressesData1){                           //validate the new address matches an address in the list
            if (addressData1.getText().equals(name + ", " + address + ", " + cityInfo + ", " + state + ", " + country)){
                matchFound1 = true;                          //There is an address that matches the new address
                break;
            }
        }
        Assert.assertTrue(matchFound);

    }
}
