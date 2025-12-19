package ru.mos.qa.testtasks.playground.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AjaxPage {
    @FindBy(how= How.XPATH, using = "//button[text()='Button Triggering AJAX Request']")
    WebElement buttonToTrigger;

    @FindBy(how= How.XPATH, using = "//p[text()='Data loaded with AJAX get request.']")
    WebElement needText;



    private WebDriverWait wait;
    private WebDriver driver;

    public AjaxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void buttonClick(){

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button Triggering AJAX Request']")));
        buttonToTrigger.click();

    }

    public boolean foundText(String text){

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Data loaded with AJAX get request.']")));
        if (needText.getText().contains(text)){
            return true;
        }
        return false;

    }
}
