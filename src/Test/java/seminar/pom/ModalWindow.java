package seminar.pom;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {

    private final SelenideElement studentNameInput = $("#student-name-input");
    private final SelenideElement addButton = $("#add-button");
    private final SelenideElement closeButton = $("#close-button");

    public void addStudent(String studentName) {
        studentNameInput.setValue(studentName);
        addButton.click();
    }

    public void close() {
        closeButton.click();
    }
}
