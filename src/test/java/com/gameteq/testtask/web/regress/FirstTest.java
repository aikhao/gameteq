package com.gameteq.testtask.web.regress;

import com.gameteq.testtast.web.libs.Offer;
import com.gameteq.testtast.web.libs.Offers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class FirstTest {
    public static WebDriver driver;

    public static com.gameteq.testtast.web.entities.Offer newOffer = com.gameteq.testtast.web.entities.Offer.builder()
            .name("testName")
            .key("testKeyss")
            .category("Art")
            .networks(new String[] {"Facebook"})
            .group("NEW_GROUP")
            .segment("Newentity")
            .build();


    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void aTest() throws InterruptedException {
        Offer offer = new Offer(driver);
        Offers offers = new Offers(driver);

        Offer.openPage();

        Offer.setName(newOffer.getName());
        Offer.setKey(newOffer.getKey());
        Offer.setCategory(newOffer.getCategory());
        Offer.setNetworks(newOffer.getNetworks());
        Offer.setGroup(newOffer.getGroup());
        Offer.clickAddSegmentButton();
        Offer.setSegment(newOffer.getSegment());
        Offer.clickSaveButton();
        Offers.checkExistTableContent();
        assertTrue(Offers.checkExistLastOfferWithKey(newOffer.getKey()));

    }

    @Test
    public void bTest() throws InterruptedException {
        Offers offers = new Offers(driver);

        Offers.openPage();
        Offers.checkExistTableContent();
        assertTrue(Offers.checkExistOfferWithKey(newOffer.getKey()));
        Offers.clickDeleteButtonForOfferWithKey(newOffer.getKey());
        Offers.approveDelete();
        Offers.checkExistTableContent();
        assertFalse(Offers.checkExistOfferWithKey(newOffer.getKey()));

    }


    @After
    public void afterTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
