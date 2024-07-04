package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P01_register {
    @FindBy(id = "slider-carousel")
    public WebElement homePageLoaded;

    @FindBy(css = "a[href=\"/login\"]")
    public WebElement goToRegisterPage;

    @FindBy(css = "div[class=\"signup-form\"]>h2")
    public WebElement newUserSignup;

    @FindBy(name = "name")
    public WebElement username;

    @FindBy(css = "input[data-qa=\"signup-email\"]")
    public WebElement email;

    @FindBy(css = "button[data-qa=\"signup-button\"]")
    public WebElement signupButton;

    @FindBy(css = "div>h2[class*=\"title\"]")
    public WebElement createAccountForm;

    public P01_register() {
        PageFactory.initElements(driver, this);
    }
}