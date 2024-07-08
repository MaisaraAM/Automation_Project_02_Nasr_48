package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_homepage {
    @FindBy(css = "a[href=\"/products\"]")
    public WebElement productsPage;

    @FindBy(css = "h2.title.text-center")
    public WebElement productsListTitle;

    @FindBy(className = "product-image-wrapper")
    public List<WebElement> productsList;

    @FindBy(css = "a[href=\"/product_details/1\"]")
    public WebElement product1;

    @FindBy(css = "div[class=\"product-information\"]>h2")
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

    @FindBy(css = "h2.title.text-center")
    public WebElement searchResults;

    @FindBy(css = "div.productinfo.text-center>p")
    public List<WebElement> productSeachList;

    public P03_homepage() {
        PageFactory.initElements(driver, this);
    }
}