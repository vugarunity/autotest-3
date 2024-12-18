package seminar.pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
    }

    private SelenideElement usernameField = $("form#login input[type='text']");
    private SelenideElement passwordField = $("form#login input[type='password']");
    private SelenideElement loginButton = $("form#login button");
    private SelenideElement errorBlock = $("div.error-block");

    public void open() {

        $("https://test-stand.gb.ru/login");
    }

    public void login(String username, String password) {
        typeUsernameInField(username);
        typePasswordInField(password);
        clickLoginButton();
    }

    public void typeUsernameInField(String username) {
        usernameField.shouldBe(visible).setValue(username);
    }

    public void typePasswordInField(String password) {
        passwordField.shouldBe(visible).setValue(password);
    }

    public void clickLoginButton() {

        loginButton.shouldBe(visible).click();
    }

    public String getErrorBlockText() {
        return errorBlock.shouldBe(visible).getText().replace("\n", " ");
    }

}
