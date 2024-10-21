package tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTest {

 WebDriver driver;
 CheckoutPage checkoutPage;
 LoginPage loginPage;
 HomePage homePage;
 ShoppingPage ShoppingPage;
 SecureAreaPage SecureAreaPage;

 @BeforeClass
 public void checkoutPreconditions ()
 {
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  checkoutPage = new CheckoutPage(driver);
  homePage = new HomePage(driver);
  loginPage = new LoginPage(driver);
  ShoppingPage= new ShoppingPage(driver);
  SecureAreaPage = new SecureAreaPage(driver);
 }
 @Test(priority =1)
 public void userLoginThenNavigateToHomePage ()
 {
  loginPage.navigateToLogin();
  loginPage.login("new330@gmail.com","11111");
  homePage.navigateToHomePage();
 }

 @Test (priority =2)
 public void userAddProductsToTheCart ()
 {
  ShoppingPage.Product1().Product2();
 }

 @Test (priority = 3)
 public void verifyWhenUserClickOnTheCheckoutTheCheckoutPageAppear()
 {
  homePage.navigateCheckout().checkoutPageAppearance().billingDetailsStepAppearance();
 }

 //step2 testcases 1)user enter valid data and move to the next step successfully  2)user leaves the fields empty  3) user exceed the max limit of chars
 @Test (priority = 4)
 public void VerifyErrorMSGIsDisplayedWhenUserLeaveSomeRequiredFieldsEmpty()
 {
  checkoutPage.EnterDataForTheAddress("", "","AinShams1","AinShams2", "cairo" , "4543070")
          .verifyErrorMessageDisplayedforinvalidData();
 }
 @Test (priority = 5)
 public void VerifyErrorMSGIsDisplayedWhenUserExceedTheMaxLimitForNames()
 {
  checkoutPage.EnterDataForTheAddress("very very very very very long name","Samy","","", "" , "")
              .verifyErrorMessageDisplayedforinvalidData();
 }

 @Test (priority = 6)
 public void userEnterValidDataInTheBillingDetails()
 {
  checkoutPage.EnterDataForTheAddress("Bassant","","","", "" , "");
 }
 /*

 @Test(priority =4 )
 public void userChooseExistingAddressInBillingDetails()
 {
  checkoutPage.chooseExistingAddressinBillingDetails();
 }*/

 //step3 test cases :1) verify user can use the existing add. and move to the next step successfully 2) verify user can add new add. and move to the next step successfully
 @Test (priority = 7)
 public void verifyUserCanUseTheExistingAddressInDeliveryDetails ()
 {
  checkoutPage.verifyExistingAddressIsTheAddressYouEntered()
          .userChooseExistingAddress().
          verifyMovingToDeliveryMethodSuccessfullyAfterContinue();
 }
 @Test (priority = 8)
 public void verifyUserCanEnterNewAddressAndMoveToTheNextStepSuccessfully()
 {
  checkoutPage.userChooseEnteringNewAddress()
          .enterNewAddress("Bassant","Samy","Zaitoun1","Zaitoun2", "Cairo" , "11725")
          .verifyMovingToDeliveryMethodSuccessfullyAfterContinue();
 }

 //step4 test cases : verify that the user enter comment and move to step5 successfully
 @Test (priority = 9)
 public void VerifyTheDeliveryMethodStep ()
 {
  checkoutPage.verifyFlatRateIsCheckedByDefault()
          .userEnterComment("comment")
          .verifyMovingToPaymentMethodSuccessfullyAfterContinue();
 }

 //step5 test cases : 1)verify error message is displayed when the user doesn't check the terms and conditions then press continue  2) verify moving to ci=onfirm order successefully after cheching the box and click on continue
 @Test (priority = 10)
 public void verifyErrorMSGDisplayedWhenTheUSerNotCheckTheTermsAndConditions()
 {
  checkoutPage.verifyPaymentMethodRadioIsCheckedByDefault()
          .clickingOnContinue()
          .verifyErrorMSGDisplayedWhenTheBoxNotChecked();
 }
 @Test (priority = 11)
 public void verifyUserMovesSuccessfullyToConfirmOrderAfterCheckingTheTermsAndCond()
 {
  checkoutPage.verifyPaymentMethodRadioIsCheckedByDefault()
          .checkTheTermsAndConditionBox()
          .clickingOnContinue()
          .verifyMovingToTheConfirmOrderAfterContinue();
 }

 //Step6 test cases : 1)verify the products name are the same you purchased 2) verify the quantity 3) verify the money are correct
 @Test(priority = 12)
 public void verifyTheProductsDetailsAreTheSameYouPurchased()
 {
  checkoutPage.verifyTheProductIsTheSameYouPurchased("iPhone","MacBook")
          .verifyTheQuantityOfProductsIsDiplayed()
          .verifyThePriceOfProductIsDiplayed()
          .verifyTheTotalPriceOfProductsIsDiplayed()
          .verifyTheShippingFeesIsDiplayed();
 }
 @Test(priority = 13)
 public void verifySuccessMSGDisplayedAfterConfirmingTheOrder ()
 {
  checkoutPage.verifySuccessMSGWhenUserConfirmTheOrder();
 }
 @Test(priority = 14)
 public void verifyUserGoesToHomePageAfterClickingContinue()
 {
  checkoutPage.verifyTheUserGoesToTheHomePageAfterClickingContinue();
 }

 @AfterClass
 public void flush()
 {
  driver.close();
 }
 }

