package sauce.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import sauce.inventory.ProductList;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    ShoppingCartIcon shoppingCartIcon;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void addItems(List<String> items) {
        for(String itemName : items) {
            addItem(itemName);
        }
        // OR items.forEach(this::item);
    }

    @Step
    public void openCart() {
        $(ShoppingCartIcon.link()).click();
    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}
