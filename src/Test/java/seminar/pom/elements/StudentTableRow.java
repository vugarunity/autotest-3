package seminar.pom.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class StudentTableRow {

    private final SelenideElement root;

    public StudentTableRow(SelenideElement root) {
        this.root = root;
    }

    public String getName() {
        return root.$(By.xpath("./td[2]")).getText();
    }

    public String getStatus() {
        return root.$(By.xpath("./td[4]")).getText();
    }

    public void clickTrashIcon() {
        root.$(By.xpath("./td/button[text()='delete']")).click();
        waitUntil(() -> root.$(By.xpath("./td/button[text()='restore_from_trash']")).shouldBe(visible));
    }

    public void clickRestoreFromTrashIcon() {
        root.$(By.xpath("./td/button[text()='restore_from_trash']")).click();
        waitUntil(() -> root.$(By.xpath("./td/button[text()='delete']")).shouldBe(visible));
    }

    private void waitUntil(Runnable condition) {
        condition.run();
    }
}
