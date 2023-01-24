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
import static com.gameteq.testtast.web.view.pages.OfferPage.inputKey;
import static com.gameteq.testtast.web.view.pages.OfferPage.inputName;
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
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.mat-option-text")));

        List<WebElement> options= driver.findElements(By.cssSelector("span.mat-option-text"));
        for(WebElement e: options){
            if(Arrays.stream(networks).anyMatch(e.getText()::equals)) e.click();
        }
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        Thread.sleep(3000);
    }

    public static void setGroup(String group) throws InterruptedException {
        driver.findElement(selectGroup).click();
//        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.mat-option-text")));
//        Thread.sleep(3000);
//        List<WebElement> options1= driver.findElements(By.cssSelector("span.mat-option-text"));
//        for(WebElement e: options1){
//            if(e.getText().equals(group)) {
//                e.click();
//            }
//        }

        driver.findElement(By.xpath("//span[contains(text(),'"+group+"')][@class='mat-option-text']")).click();
//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
    }

    public static void openPage() {
        driver.get(Properties.urlFront + Constants.Urls.newOffer);
    }

    public static void clickSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
        ////tbody//tr[last()]//td[comtains,(class(),"mat-column-key")]
    }

    public static void setSegment(String segment) {
        driver.findElement(selectSegment).click();
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.mat-option-text")));

//        List<WebElement> options= driver.findElements(By.cssSelector("span.mat-option-text"));
//        for(WebElement e: options){
//            if(e.getText().equals(segment)) {
//                e.click();
//                return;
//            }
//        }
        driver.findElement(By.xpath("//span[contains(text(),'"+segment+"')][@class='mat-option-text']")).click();

    }

    public static void clickAddSegmentButton() {
        driver.findElement(buttonAddSegment).click();
    }
}
