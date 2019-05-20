
import com.codeborne.selenide.Condition;


import models.Item;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.page;

public class SearchTest extends BaseTest {

    private static final String TEST_QUERY = "Batman comics";

    @Test
     public void searchItemTest() {
        NavigationBar search = page(NavigationBar.class);
        SearchResultsPage resultsPage = search.searchProducts(TEST_QUERY);
        Assert.assertTrue( resultsPage.getSearchResultsNumber() > 0, "results number should be above 0");
        resultsPage.getSearchResultElement(0).$("span.a-size-medium")
                .shouldHave(Condition.text(TEST_QUERY.substring(0, TEST_QUERY.indexOf(' '))));
        resultsPage.getSearchResultElement(0).$(".a-price-symbol").shouldHave(Condition.text("€"));
        resultsPage.getSearchResultElement(0).$("span.a-icon-alt").isDisplayed();
        Item expectedItem = resultsPage.getItem(0);
        ItemDetailsPage itemDetailsPage = resultsPage.clickItem(0);
        Item actualItem = itemDetailsPage.getItem();
        Assert.assertTrue(expectedItem.equals(actualItem), "title and price are equal to the ones in search result");
    }
}
