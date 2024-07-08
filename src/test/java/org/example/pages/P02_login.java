package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class P02_login {
    ////    F02
    @FindBy(className = "login-form")
    public WebElement loginToYourAccount;

    @FindBy(css = "input[data-qa=\"login-email\"]")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[data-qa=\"login-button\"]")
    public WebElement loginButton;

    @FindBy(css = "p[style*=\"color\"]")
    public WebElement errorMsg;

    public P02_login() {
        PageFactory.initElements(driver, this);
    }
}