package ru.mos.qa.testtasks.tests.playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.mos.qa.testtasks.playground.pages.AjaxPage;

public class PlaygroundTest extends BaseTests{

    @Test
    @DisplayName("Проверка что на элемент")
    public void testFoundString() {
        driver.get("http://uitestingplayground.com/ajax");

        AjaxPage ajaxPageFactory = PageFactory.initElements(driver, AjaxPage.class);

        ajaxPageFactory.buttonClick();

        boolean isText = ajaxPageFactory.foundText("Data loaded with AJAX get request.");

        Assertions.assertTrue(isText, "Текст не найден.");

    }
}
