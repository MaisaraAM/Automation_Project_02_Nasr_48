package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homepage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D02_login {
    P02_login login = new P02_login();
    P03_homepage homepage = new P03_homepage();
    SoftAssert sftAsrt = new SoftAssert();

    @Then("verify 'Login to your account' is visible")
    public void verifyLoginToYourAccountIsVisible() {
        String actualAccountLoginText = login.loginToYourAccount.getText().toLowerCase();
        String expectedAccountLoginText = "login to your account";
        sftAsrt.assertTrue(actualAccountLoginText.contains(expectedAccountLoginText));
    }

    @When("user enters correct email")
    public void userEntersCorrectEmail() throws IOException {
        String genEmail = configurations.getFake("genEmail");
        login.email.sendKeys(genEmail);
    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() throws IOException {
        String genPassword = configurations.getFake("genPassword");
        login.password.sendKeys(genPassword);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        login.loginButton.click();
    }

    @When("user enters incorrect email {string}")
    public void userEntersIncorrectEmail(String incorrectEmail) {
        login.email.sendKeys(incorrectEmail);
    }

    @And("user enters incorrect password {string}")
    public void userEntersIncorrectPassword(String incorrectPassword) {
        login.password.sendKeys(incorrectPassword);
    }

    @Then("verify error 'Your email or password is incorrect!' is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        String actualFailedLoginText = login.errorMsg.getText().toLowerCase();
        String expectedFailedLoginText = "your email or password is incorrect";
        sftAsrt.assertTrue(actualFailedLoginText.contains(expectedFailedLoginText));

        Color errorMsgColour = Color.fromString(login.errorMsg.getCssValue("color"));
        sftAsrt.assertEquals(errorMsgColour.asHex(), "#ff1a1a");
    }

    @When("user clicks logout button")
    public void userClicksLogoutButton() {
        homepage.logoutButton.click();
    }

    @Then("verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }
}