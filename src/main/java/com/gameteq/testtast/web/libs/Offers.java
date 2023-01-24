package com.gameteq.testtast.web.libs;

import com.gameteq.testtast.web.helper.Constants;
import com.gameteq.testtast.web.properties.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Offers {
    static WebDriver driver;

    public Offers(WebDriver driver) {
        Offers.driver =driver;
    }

    public static void checkExistTableContent() {
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("mat-sidenav-content table.mat-table")));

    }

    public static boolean checkExistLastOfferWithKey(String key) {
        return driver.findElement(By.xpath("//tbody//tr[last()]//td[contains(@class, 'mat-column-key')]")).getText().equals(key);
    }

    public static boolean checkExistOfferWithKey(String key) {

        List<WebElement> elements = driver.findElements(By.xpath("//tbody//tr//td[contains(@class, 'mat-column-key')]"));
        for(WebElement e:elements){
            if (e.getText().equals(key)) {
                return true;
            }
        }
//        return driver.findElement(By.xpath("//tbody//tr[last()]//td[contains(@class, 'mat-column-key')]")).getText().equals(key);
        return false;
    }


    public static void openPage() {
        driver.get(Properties.urlFront + Constants.Urls.Offers);
    }

    public static void clickDeleteButtonForOfferWithKey(String key) {
        List<WebElement> elements = driver.findElements(By.xpath("//tbody//tr//td[contains(@class, 'mat-column-key')]"));
        for(WebElement e:elements){
            if(e.getText().equals(key)){
                e.findElement(By.xpath("ancestor::tr/td[contains(@class, 'mat-column-actions')]//span[text()=' Delete ']")).click();
                break;

            }

        }
//        driver.findElement(By.cssSelector("//tbody//td[contains(@class, 'mat-column-actions')]//span[text()=' Delete ']")).click();



    }

    public static void approveDelete() {
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cdk-overlay-container button")));


        driver.findElement(By.cssSelector("div.cdk-overlay-container button")).click();

    }
}
