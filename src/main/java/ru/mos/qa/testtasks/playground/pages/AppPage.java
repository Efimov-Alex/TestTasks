package ru.mos.qa.testtasks.playground.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.mos.qa.testtasks.playground.config.TestConfig.*;

public class AppPage {
    @FindBy(how= How.XPATH, using = "//input[@placeholder='User Name']")
    WebElement usernameText;

    @FindBy(how= How.XPATH, using = "//input[@name='Password']")
    WebElement passwordText;

    @FindBy(how= How.XPATH, using = "//button[@id='login']")
    WebElement buttonToClick;

    @FindBy(how= How.XPATH, using = "//label[@id='loginstatus']")
    WebElement label;



    private WebDriverWait wait;
    private WebDriver driver;

    public AppPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    public void textInput(String username, String password){

        wait.until(ExpectedConditions.elementToBeClickable(usernameText));
        usernameText.sendKeys(username);
        passwordText.sendKeys(password);

    }

    public void clickButton(){
        buttonToClick.click();
    }

    public boolean foundText(String text){

        wait.until(ExpectedConditions.elementToBeClickable(label));
        if (label.getText().contains(text)){
            return true;
        }
        return false;

    }
}
