package com.gameteq.testtast.web.view.pages;

import org.openqa.selenium.By;

public class OffersPage {

    public static By tablePaymentTransaction = By.id("payment-system-transaction-grid");
    public static By selectPlayerSearchStatus = By.name("PlayerSearch[status]");
    public static By columnPlayerSearchStatus = By.cssSelector("td:nth-child(15) span");

}
