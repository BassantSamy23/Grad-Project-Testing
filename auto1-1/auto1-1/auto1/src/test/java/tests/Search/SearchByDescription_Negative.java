package tests.Search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SearchResults;

public class SearchByDescription_Negative extends TestBase {

    //Page objects

    SearchResults searchResults;

    @BeforeClass
    public void preConditions(){
        searchResults = new SearchResults(driver);
    }
    @Test       //Validate that search results match the query
    public void validateSearchByDescription(){
        String [] queries = {"20 GIGA ram"};
        for (String query : queries){
            searchResults
                    .enterQuery(query)
                    .selectSearchByDescription()
                    .validateNoProductsMessage();
        }
    }
}

