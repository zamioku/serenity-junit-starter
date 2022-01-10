package sauce.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import sauce.authentication.actions.LoginActions;
import sauce.inventory.InventoryPage;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static sauce.authentication.actions.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingIn {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogInViaTheHomePage() {
//        driver.get("https://saucedemo.com/");

        // Login as a standard user
        login.as(STANDARD_USER);

        // Should see product catalogue
        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));
    }
}
