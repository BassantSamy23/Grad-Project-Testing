package tests.Search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SearchResults;

public class SearchByDescription_Positive extends TestBase {

    //Page objects

    SearchResults searchResults;

    @BeforeClass
    public void preConditions(){
        searchResults = new SearchResults(driver);
    }
    @Test       //Validate that search results match the query
    public void validateSearchByDescription(){
        String [] queries = {"30-inch", "Intel Core 2 Duo", "80GB or 160GB of storage", "canon"};
        for (String query : queries){
            searchResults
                    .enterQuery(query)
                    .selectSearchByDescription()
                    .validateSearchByDescription(query);
        }

    }

}
