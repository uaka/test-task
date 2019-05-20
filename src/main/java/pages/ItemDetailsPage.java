package pages;

import com.codeborne.selenide.SelenideElement;

import models.Item;
import org.openqa.selenium.By;
import java.math.BigDecimal;
import static com.codeborne.selenide.Selenide.$;

public class ItemDetailsPage extends NavigationBar {

    public Item getItem() {
        String name = $(By.id("productTitle")).text();
        SelenideElement priceElem = $(".offer-price").isDisplayed()? $(".offer-price"): $(By.id("priceblock_ourprice"));
        String price = priceElem.text().replace(',', '.').replace("EUR ", "").replace(" €", "");
        return new Item(name, new BigDecimal(price));
    }
}
