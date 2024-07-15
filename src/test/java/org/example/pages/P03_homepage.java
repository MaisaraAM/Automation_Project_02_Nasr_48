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

    ////    F02
    @FindBy(css = "ul>li>a[href=\"/logout\"]")
    public WebElement logoutButton;

    ////    F03
    @FindBy(css = "ul>li>a[href=\"/products\"]")
    public WebElement productsPage;

    ////    F05
    @FindBy(css = "ul>li>a[href=\"/delete_account\"]")
    public WebElement deleteAcntButton;

    @FindBy(css = "ul>li>a[href=\"/view_cart\"]")
    public WebElement cartPage;

    public P03_homepage() {
        PageFactory.initElements(driver, this);
    }
}