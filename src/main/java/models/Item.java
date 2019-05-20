package models;
import java.math.BigDecimal;

public class Item {

    private String title;
    private BigDecimal price;

    public Item(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        Item that = (Item) obj;
        return this.title.equals(that.title) && this.price.compareTo(that.price) == 0;
    }

    @Override
    public String toString() {
        return String.format("title: %s, price: %s", this.title, this.price.toString());
    }
}
