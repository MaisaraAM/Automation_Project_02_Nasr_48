package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P06_checkout {
    ////    F05
    @FindBy(css = "#address_delivery>li.address_firstname")
    public WebElement dlvrAdrsName;

    @FindBy(css = "#address_delivery>li:nth-child(4)")
    public WebElement dlvrAdrsAdrs1;

    @FindBy(css = "#address_delivery>li.address_city")
    public WebElement dlvrAdrsCtStZip;

    @FindBy(css = "#address_delivery>li.address_country_name")
    public WebElement dlvrAdrsCntry;

    @FindBy(css = "#address_delivery>li.address_phone")
    public WebElement dlvrAdrsPhone;

    @FindBy(css = "#address_invoice>li.address_firstname")
    public WebElement billAdrsName;

    @FindBy(css = "#address_invoice>li:nth-child(4)")
    public WebElement billAdrsAdrs1;

    @FindBy(css = "#address_invoice>li.address_city")
    public WebElement billAdrsCtStZip;

    @FindBy(css = "#address_invoice>li.address_country_name")
    public WebElement billAdrsCntry;

    @FindBy(css = "#address_invoice>li.address_phone")
    public WebElement billAdrsPhone;

    @FindBy(css = "tbody>tr>td:nth-child(4)>p.cart_total_price")
    public WebElement orderTotal;

    @FindBy(className = "form-control")
    public WebElement orderComment;

    @FindBy(css = "div>a[href=\"/payment\"]")
    public WebElement placeOrder;

    @FindBy(name = "name_on_card")
    public WebElement nameOnCard;

    @FindBy(name = "card_number")
    public WebElement cardNumber;

    @FindBy(name = "cvc")
    public WebElement cardCVC;

    @FindBy(name = "expiry_month")
    public WebElement expiryMon;

    @FindBy(name = "expiry_year")
    public WebElement expiryYear;

    @FindBy(id = "submit")
    public WebElement payOrder;

    @FindBy(css = "#success_message>div")
    public WebElement orderPlacMsg;

    public P06_checkout() {
        PageFactory.initElements(driver, this);
    }
}