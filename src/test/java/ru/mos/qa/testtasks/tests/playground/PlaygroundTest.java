package ru.mos.qa.testtasks.tests.playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.mos.qa.testtasks.playground.pages.AjaxPage;
import ru.mos.qa.testtasks.playground.pages.AppPage;

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

    @Test
    @DisplayName("Проверка что на успешную авторизацию")
    public void testSuccessAuth() {
        driver.get("http://uitestingplayground.com/sampleapp");

        AppPage appPage = PageFactory.initElements(driver, AppPage.class);

        appPage.textInput("aaa", "pwd");

        appPage.clickButton();

        boolean isText = appPage.foundText("Welcome,");

        Assertions.assertTrue(isText, "Авторизация не успешна.");
    }

    @Test
    @DisplayName("Проверка что на неуспешную авторизацию")
    public void testUnsuccessAuth() {
        driver.get("http://uitestingplayground.com/sampleapp");

        AppPage appPage = PageFactory.initElements(driver, AppPage.class);

        appPage.textInput("aaa", "bad_password");

        appPage.clickButton();

        boolean isText = appPage.foundText("Invalid username/password");

        Assertions.assertTrue(isText, "Авторизация успешна.");
    }

    @Test
    @DisplayName("Проверка что на авторизацию с пустым логином")
    public void testEmptyLogin() {
        driver.get("http://uitestingplayground.com/sampleapp");

        AppPage appPage = PageFactory.initElements(driver, AppPage.class);

        appPage.textInput("", "pwd");

        appPage.clickButton();

        boolean isText = appPage.foundText("Invalid username/password");

        Assertions.assertTrue(isText, "Авторизация успешна.");
    }
}
