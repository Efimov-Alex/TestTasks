package ru.mos.qa.testtasks.playground.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.mos.qa.testtasks.playground.config.TestConfig.*;

public class AjaxPage {
    @FindBy(how= How.XPATH, using = "//button[text()='" + AJAX_BUTTON_TEXT + "']")
    WebElement buttonToTrigger;

    @FindBy(how= How.XPATH, using = "//p[text()='" + AJAX_SUCCESS_TEXT + "']")
    WebElement needText;



    private WebDriverWait wait;
    private WebDriver driver;

    public AjaxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    public void buttonClick(){

        wait.until(ExpectedConditions.elementToBeClickable(buttonToTrigger));
        buttonToTrigger.click();

    }

    public boolean foundText(String text){

        wait.until(ExpectedConditions.elementToBeClickable(needText));
        if (needText.getText().contains(text)){
            return true;
        }
        return false;

    }
}
