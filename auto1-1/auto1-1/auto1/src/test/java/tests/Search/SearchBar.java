package tests.Search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;

public class SearchBar extends TestBase{

    //Pages Object deceleration

    HomePage homePage;


    @BeforeClass
    public void preConditions(){

        //Pages object initialization

        homePage = new HomePage(driver);


        homePage.navigateToHomePage();    //Navigate to home page
    }

    @Test(priority = 1)  //Check visibility of search bar
    public void validateSearchBarVisibility(){
        homePage.validateSearchBarVisibility();
    }
    @Test(priority = 2)  //Check that search bar submit query by clicking on search icon or pressing enter
    public void validateSubmitQuery(){
        homePage.validateSubmitQueryClickingSearchIcon();
        homePage.validateSubmitQueryPressingEnter();
    }

}
