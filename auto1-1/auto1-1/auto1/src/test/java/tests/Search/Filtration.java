package tests.Search;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SearchResults;

public class Filtration extends TestBase {

    //Pages object
    SearchResults searchResults;

    @BeforeClass
    public void preConditions(){
        searchResults = new SearchResults(driver);
    }
    @Test //Validate search results by select MP3 players category
    public void validateMp3PlayerCategorization(){
        searchResults
                .enterQuery("Ip")
                .selectCategory("MP3 Players")
                .validateMp3PlayerCategorization();
    }
    @Test //Validate search results by select MP3 players category
    public void validateCameraCategorization(){
        searchResults
                .enterQuery("NI")
                .selectCategory("Cameras")
                .validateCamerasCategorization();
    }
    @Test //Validate sorting by the lowest price
    public void ValidateSortByLowestPrice(){
        searchResults
                .enterQuery("i")
                .sortBy("Price (Low > High)")
                .validateSortingLowestPrice();
    }
    @Test //Validate search results by select MP3 players category and sorting by the lowest price
    public void ValidateCategorizationAndSorting(){
        searchResults
                .enterQuery("NI")
                .selectCategory("Cameras")
                .sortBy("Price (Low > High)")
                .validateSortingLowestPrice()
                .validateCamerasCategorization();
    }
    @Test //validate sorting by name(A-Z)
    public void validateSortingByName_A(){
        searchResults
                .enterQuery("i")
                .sortBy("Name (A - Z)")
                .validateSortingByName_A();
    }


}
