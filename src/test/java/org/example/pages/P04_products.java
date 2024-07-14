package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P04_products {
    ////    F03
    @FindBy(css = "div.features_items>h2")
    public WebElement productsListTitle;

    @FindBy(className = "single-products")
    public List<WebElement> productsList;

    @FindBy(css = "a[href=\"/product_details/1\"]")
    public WebElement product1;

    @FindBy(css = "div.product-information>h2")
    public WebElement product1Name;

    @FindBy(css = "div>p:nth-child(3)")
    public WebElement product1Category;

    @FindBy(css = "span>span")
    public WebElement product1Price;

    @FindBy(css = "div>p:nth-child(6)")
    public WebElement product1Availability;

    @FindBy(css = "div>p:nth-child(7)")
    public WebElement product1Condition;

    @FindBy(css = "div>p:nth-child(8)")
    public WebElement product1Brand;

    @FindBy(id = "search_product")
    public WebElement searchField;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(css = "div.features_items>h2")
    public WebElement searchResults;

    @FindBy(css = "div.productinfo>p")
    public List<WebElement> productSeachList;

    ////    F04
    @FindBy(css = "a[data-product-id=\"1\"]")
    public WebElement addProd1ToCart;

    @FindBy(css = "button.btn.btn-success")
    public WebElement contShopBtn;

    @FindBy(css = "a[data-product-id=\"2\"]")
    public WebElement addProd2ToCart;

    @FindBy(css = "a[href=\"/product_details/2\"]")
    public WebElement product2;

    @FindBy(id = "quantity")
    public WebElement prodQnty;

    @FindBy(css = "button.btn.btn-default.cart")
    public WebElement addProdQntyToCart;

    public P04_products() {
        PageFactory.initElements(driver, this);
    }
}