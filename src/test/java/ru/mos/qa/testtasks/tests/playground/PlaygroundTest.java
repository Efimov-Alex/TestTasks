package ru.mos.qa.testtasks.tests.playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.mos.qa.testtasks.playground.pages.AjaxPage;
import ru.mos.qa.testtasks.playground.pages.AppPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mos.qa.testtasks.playground.config.TestConfig.*;

@DisplayName("UITestingPlayground - Тесты для проверки функциональности")
public class PlaygroundTest extends BaseTests{

    @Test
    @DisplayName("AJAX Data: Проверка загрузки данных через AJAX запрос")
    public void testFoundString() {
        driver.get(AJAX_PAGE_URL);

        AjaxPage ajaxPageFactory = PageFactory.initElements(driver, AjaxPage.class);

        ajaxPageFactory.buttonClick();

        boolean isText = ajaxPageFactory.foundText(AJAX_SUCCESS_TEXT);

        Assertions.assertTrue(isText, "Текст не найден.");

    }

    @ParameterizedTest(name = "Sample App: Авторизация с данными {0}")
    @MethodSource("provideLoginTestData")
    @DisplayName("Sample App: Проверка авторизации с различными данными")
    void sampleApp_ShouldHandleLogin_WithVariousCredentials(
            String testCase, String username, String password, boolean shouldSucceed) {

        driver.get(SAMPLE_APP_URL);
        AppPage appPage = PageFactory.initElements(driver, AppPage.class);

        appPage.textInput(username, password);

        appPage.clickButton();

        if (shouldSucceed) {
            assertTrue(appPage.foundText(SAMPLE_APP_SUCCESS_PREFIX),
                    "Авторизация должна быть успешной для пользователя: " + username);
        } else {
            assertTrue(appPage.foundText(SAMPLE_APP_ERROR_TEXT),
                    "Авторизация должна завершиться ошибкой для данных: " + username + "/" + password);
        }
    }

    private static Stream<Arguments> provideLoginTestData() {
        return Stream.of(
                Arguments.of("Валидные данные", "user1", "pwd", true),
                Arguments.of("Неверный пароль", "user1", "wrongpassword", false),
                Arguments.of("Пустое имя пользователя", "", "pwd", false),
                Arguments.of("Пустой пароль", "user1", "", false),
                Arguments.of("Пустые оба поля", "", "", false)
        );
    }
}
