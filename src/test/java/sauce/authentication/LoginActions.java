package sauce.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://saucedemo.com/");

        // Login as a standard user
//        $("#user-name").sendKeys(user.getUserName());
        find(By.name("user-name")).sendKeys(user.getUserName());
//        $("#password").sendKeys(user.getPassword());
        find(By.name("password")).sendKeys(user.getPassword());
//        $("#login-button").click();
        find(By.name("login-button")).click();
    }
}
