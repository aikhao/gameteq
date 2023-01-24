package com.gameteq.testtast.web.libs;

import com.gameteq.testtast.web.helper.Constants;
import com.gameteq.testtast.web.properties.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.gameteq.testtast.web.view.pages.OffersPage.popupActionButtonApprove;
import static com.gameteq.testtast.web.view.pages.OffersPage.tableButtonDelete;
import static com.gameteq.testtast.web.view.pages.OffersPage.tableContent;
import static com.gameteq.testtast.web.view.pages.OffersPage.tableKeyColumn;

public class Offers {
    static WebDriver driver;

    public Offers(WebDriver driver) {
        Offers.driver =driver;
    }

    public static void waitTableContentToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(tableContent));

    }

    public static boolean checkExistOfferWithKey(String key) {
        List<WebElement> elements = driver.findElements(tableKeyColumn);
        for(WebElement e:elements){
            if (e.getText().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void openPage() {
        driver.get(Properties.urlFront + Constants.Urls.Offers);
    }

    public static void clickDeleteButtonForOfferWithKey(String key) {
        List<WebElement> elements = driver.findElements(tableKeyColumn);
        for(WebElement e:elements){
            if(e.getText().equals(key)){
                e.findElement(tableButtonDelete).click();
                break;
            }
        }
    }

    public static void approveDelete() {
        new WebDriverWait(driver, Duration.ofSeconds(Properties.timeoutWaitStep))
                .until(ExpectedConditions.elementToBeClickable(popupActionButtonApprove));
        driver.findElement(popupActionButtonApprove).click();

    }
}
