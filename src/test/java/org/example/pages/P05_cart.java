package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P05_cart {
    ////    F04
    @FindBy(css = "#product-1>td.cart_price>p")
    public WebElement prod1CartPrice;

    @FindBy(css = "#product-2>td.cart_price>p")
    public WebElement prod2CartPrice;

    @FindBy(css = "#product-1>td.cart_quantity>button")
    public int prod1CartQnty;

    @FindBy(css = "#product-2>td.cart_quantity>button")
    public int prod2CartQnty;

    @FindBy(css = "#product-1>td.cart_total>p")
    public WebElement prod1CartTotal;

    @FindBy(css = "#product-2>td.cart_total>p")
    public WebElement prod2CartTotal;

    ////    F05
    @FindBy(css = "a.btn.btn-default.check_out")
    public WebElement checkoutButton;

    @FindBy(css = "p>a[href=\"/login\"]")
    public WebElement checkoutRegisterButton;

    public P05_cart() {
        PageFactory.initElements(driver, this);
    }
}