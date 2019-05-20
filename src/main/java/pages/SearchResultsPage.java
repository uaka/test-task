package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

import models.Item;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends NavigationBar {
    ElementsCollection searchResults = $$(".s-result-list div.a-section.a-spacing-medium");
    String itemTitleCss = "span.a-size-medium";
    String itemPriceCss = "span.a-price-whole";

    public Item getItem(int index) {
        if (searchResults.size() < 1) return null;
        String name = searchResults.get(index).$(itemTitleCss).text();
        String price = searchResults.get(index).$(itemPriceCss).text().replace(',', '.');
        return new Item(name, new BigDecimal(price));
    }

    public SelenideElement getSearchResultElement(int index) {
        return searchResults.get(index);
    }

    public int getSearchResultsNumber() {
        return searchResults.size();
    }

    public ItemDetailsPage clickItem(int index) {
        searchResults.get(index).$(itemTitleCss).click();
        return page(ItemDetailsPage.class);
    }

}
