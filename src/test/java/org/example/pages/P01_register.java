package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P01_register {
    ////    F01
    @FindBy(className = "signup-form")
    public WebElement signupForm;

    @FindBy(name = "name")
    public WebElement username;

    @FindBy(css = "input[data-qa=\"signup-email\"]")
    public WebElement email;

    @FindBy(css = "button[data-qa=\"signup-button\"]")
    public WebElement signupButton;

    @FindBy(css = "div>h2.title")
    public WebElement createAccountForm;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement dobDay;

    @FindBy(id = "months")
    public WebElement dobMon;

    @FindBy(id = "years")
    public WebElement dobYr;

    @FindBy(id = "newsletter")
    public WebElement newsletter;

    @FindBy(id = "optin")
    public WebElement offers;

    @FindBy(id = "first_name")
    public WebElement fName;

    @FindBy(id = "last_name")
    public WebElement lName;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNum;

    @FindBy(css = "button[data-qa=\"create-account\"]")
    public WebElement createAccountButton;

    @FindBy(css = "h2[data-qa=\"account-created\"]")
    public WebElement successMsg;

    @FindBy(css = "div>a[data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public P01_register() {
        PageFactory.initElements(driver, this);
    }
}