package tests.Search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SearchResults;

public class searchFunctionality_Negative extends TestBase {

    //Pages objects

    SearchResults searchResults;

    @BeforeClass
    public void preConditions(){
        searchResults = new SearchResults(driver);

    }
    @Test
    public void validateNoProductsMessage(){
        String [] queries = {"Iphone 11", "%$"};
        for (String query : queries){
            searchResults
                    .enterQuery(query)
                    .validateNoProductsMessage();
        }

    }
}
