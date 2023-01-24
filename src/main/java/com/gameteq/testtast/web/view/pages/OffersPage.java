package com.gameteq.testtast.web.view.pages;

import org.openqa.selenium.By;

public class OffersPage {

    public static By popupActionButtonApprove = By.cssSelector("div.cdk-overlay-container button");
    public static By tableButtonDelete =
            By.xpath("ancestor::tr/td[contains(@class, 'mat-column-actions')]//span[text()=' Delete ']");
    public static By tableContent = By.cssSelector("mat-sidenav-content table.mat-table");
    public static By tableKeyColumn = By.xpath("//tbody//tr//td[contains(@class, 'mat-column-key')]");

}
