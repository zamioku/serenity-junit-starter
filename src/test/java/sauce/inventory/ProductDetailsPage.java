package sauce.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetailsPage extends PageObject {
    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String itemName) {
        return $(".inventory_details_container img[alt='"+itemName+"']");
//        return $("css:img[alt='"+itemName+"']");  // use css: to remove ambiguity
    }
}
