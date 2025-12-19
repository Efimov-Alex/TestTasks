package ru.mos.qa.testtasks.tests.playground;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void before() {
        // 1. Автоматически скачает ChromeDriver (ВМЕСТО System.setProperty)
        WebDriverManager.chromedriver().setup();

        // 2. Создаем настройки
        ChromeOptions options = new ChromeOptions();

        // 3. ВСЕ эти опции ОБЯЗАТЕЛЬНЫ:
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");

        // 4. Убираем лог
        System.setProperty("webdriver.chrome.silentOutput", "true");

        // 5. Создаем драйвер
        driver = new ChromeDriver(options);

        // 6. Таймауты (увеличь!)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        // 7. Ожидания
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 8. Пауза для стабилизации
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
