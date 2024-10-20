package tests.Search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SearchResults;

@Test
public class searchFunctionality_Positive extends TestBase {

    //Pages object
    HomePage homePage;
    SearchResults searchResults;
    @BeforeClass
    public void PreConditions(){
        homePage = new HomePage(driver);
        searchResults = new SearchResults(driver);
    }

    @Test   //Validate the Search results match different types of queries
    public void validateSearchResults(){
        String [] queries = {"Ipod ClassIc", "sam", "Iphone", "IpOd", "SamSung", "Ipod Cla", ".", "i", "Samsung GalaXY" };
        for (String query : queries) {

                    homePage
                            .enterQuery(query)
                            .validateSearchResults(query);
        }
    }


}
