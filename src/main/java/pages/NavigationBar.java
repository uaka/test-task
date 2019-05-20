package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationBar {

    public SearchResultsPage searchProducts(final String query) {
        $(By.id("twotabsearchtextbox")).setValue(query);
        $(".nav-search-submit").click();
        return page(SearchResultsPage.class);
    }
}
