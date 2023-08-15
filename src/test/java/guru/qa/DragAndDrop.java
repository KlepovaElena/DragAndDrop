package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragAndDropTest1() {

        // Перенести прямоугольник А на место В
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
    }

    // Тест с помощью команды $(element).dragAndDrop($(to-element))
    @Test
    void dragAndDropTest2() {

        // Перенесьти прямоугольник А на место В
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
    }
}
