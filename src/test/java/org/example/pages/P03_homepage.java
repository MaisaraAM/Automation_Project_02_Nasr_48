package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P03_homepage {
    ////    F01
    @FindBy(id = "slider-carousel")
    public WebElement homePageLoaded;

    @FindBy(css = "ul>li>a[href=\"/login\"]")
    public WebElement goToRegisterPage;

    @FindBy(css = "ul.nav.navbar-nav>li>a>b")
    public WebElement userAccount;

    @FindBy(css = "a[href=\"/logout\"]")
    public WebElement logoutButton;

    ////    F03
    @FindBy(css = "a[href=\"/products\"]")
    public WebElement productsPage;

    ////    F04
    @FindBy(css = "p:nth-child(2)>a")
    public WebElement viewCart;

    public P03_homepage() {
        PageFactory.initElements(driver, this);
    }
}