package sauce.inventory;

import net.serenitybdd.core.pages.PageObject;

public class ProductDetailsPage extends PageObject {
    public String productName() {
        return $(".inventory_details_name").getText();
    }
}
