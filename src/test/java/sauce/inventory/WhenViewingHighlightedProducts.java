package sauce.inventory;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import sauce.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static sauce.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPage productList;

    ProductDetailsPage productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage() {
        login.as(STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6)
                .contains("Sauce Labs Backpack");
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages() {
        login.as(STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();  // Will not fail immediately

        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {
        login.as(STANDARD_USER);

        String firstItemName = productList.titles().get(0);

        productList.openProductDetailsFor(firstItemName);

        assertThat(productDetails.productName()).isEqualTo(firstItemName);

        productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible();
    }
}
