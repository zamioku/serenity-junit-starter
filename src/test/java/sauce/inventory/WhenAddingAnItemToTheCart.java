package sauce.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import sauce.authentication.LoginActions;
import sauce.cart.CartActions;
import sauce.cart.ShoppingCartIcon;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static sauce.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    CartActions cart;

    @BeforeEach
    public void login(){
        login.as(STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartBadge;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        // Check that the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
            ()-> assertThat(shoppingCartBadge.badgeCount()).isEmpty()
        );
        // Add 1 item to the cart
        cart.addItem("Sauce Labs Backpack");

        // The shopping cart badge should be 1
        Serenity.reportThat("The shopping cart badge should now be 1",
            ()-> assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1")
        );
    }
    
    ProductList productList;

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        // Add several items to the cart
        List<String> selectedItems = productList.getFirstNProductTitlesDisplayed(3);

        // Open the cart page
        cart.addItems(selectedItems);

        String cartBadgeCount = Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart badge should now be " + cartBadgeCount,
                ()-> assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount)
        );

        cart.openCart();
        // Should see all of the items listed
        Serenity.reportThat("Should see all items listed",
                ()-> assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );
    }

}
