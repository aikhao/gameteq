package com.gameteq.testtast.web.libs;

import com.gameteq.testtast.web.helper.Constants;
import com.gameteq.testtast.web.properties.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.gameteq.testtast.web.view.pages.OfferPage.buttonAddSegment;
import static com.gameteq.testtast.web.view.pages.OfferPage.buttonSave;
import static com.gameteq.testtast.web.view.pages.OfferPage.inputKey;
import static com.gameteq.testtast.web.view.pages.OfferPage.inputName;
import static com.gameteq.testtast.web.view.pages.OfferPage.popupSelectElements;
import static com.gameteq.testtast.web.view.pages.OfferPage.selectCategory;
import static com.gameteq.testtast.web.view.pages.OfferPage.selectGroup;
import static com.gameteq.testtast.web.view.pages.OfferPage.selectNetworks;
import static com.gameteq.testtast.web.view.pages.OfferPage.selectSegment;

public class Offer {

    static WebDriver driver;

    public Offer(WebDriver driver) {
        Offer.driver =driver;
    }

    public static void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public static void setKey(String key) {
        driver.findElement(inputKey).sendKeys(key);
    }

    public static void setCategory(String category) {
        new Select(driver.findElement(selectCategory)).selectByVisibleText(category);
    }

    public static void setNetworks(String[] networks) throws InterruptedException {
        driver.findElement(selectNetworks).click();
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(popupSelectElements));

        List<WebElement> options= driver.findElements(popupSelectElements);
        for(WebElement e: options){
            if(Arrays.stream(networks).anyMatch(e.getText()::equals)) e.click();
        }
        driver.findElement(By.cssSelector(Constants.ElementsTag.body)).sendKeys(Keys.ESCAPE);
    }

    public static void setGroup(String group) throws InterruptedException {
        driver.findElement(selectGroup).click();
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(popupSelectElements));
        List<WebElement> elements = driver.findElements(popupSelectElements);
        for(WebElement e:elements){
            if(e.getText().equals(group)){
                e.click();
                break;
            }
        }
    }

    public static void openPage() {
        driver.get(Properties.urlFront + Constants.Urls.newOffer);
    }

    public static void clickSaveButton() throws InterruptedException {
        driver.findElement(buttonSave).click();
    }

    public static void setSegment(String segment) {
        driver.findElement(selectSegment).click();
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(popupSelectElements));
        List<WebElement> elements = driver.findElements(popupSelectElements);
        for(WebElement e:elements){
            if(e.getText().equals(segment)){
                e.click();
                break;
            }
        }
    }

    public static void clickAddSegmentButton() {
        driver.findElement(buttonAddSegment).click();
    }
}
