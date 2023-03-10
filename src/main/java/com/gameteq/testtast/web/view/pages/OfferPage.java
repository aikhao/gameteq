package com.gameteq.testtast.web.view.pages;

import org.openqa.selenium.By;

public class OfferPage {
    public static By buttonAddSegment =
            By.xpath("//*[@name='segments']//button/span[text()=' Add segment ']");
    public static By buttonSave = By.xpath("//button/span[contains(text(),'Save')]");
    public static By inputKey = By.name("key");
    public static By inputName = By.name("name");
    public static By selectCategory = By.name("category");
    public static By selectGroup = By.id("mat-select-1");
    public static By selectNetworks = By.id("mat-select-0");
    public static By selectSegment = By.cssSelector("#mat-select-2 span");
    public static By popupSelectElements = By.cssSelector("span.mat-option-text");
}
