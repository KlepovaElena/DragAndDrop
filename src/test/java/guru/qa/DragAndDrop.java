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
    }

    @Test
    void dragAndDropTest1() {

        // Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перенести прямоугольник А на место В

        actions().dragAndDrop($("#column-a"), $("#column-b"));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
    }

    // Тест с помощью команды
    @Test
    void dragAndDropTest2() {

        // Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перенесьти прямоугольник А на место В
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(Condition.text("B"));
    }
}
