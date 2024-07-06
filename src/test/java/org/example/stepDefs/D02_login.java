package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D02_login {
    P02_login login = new P02_login();
    SoftAssert sftAsrt = new SoftAssert();

    @Then("verify 'Login to your account' is visible")
    public void verifyLoginToYourAccountIsVisible() {
        String actualAccountLoginText = login.loginToYourAccount.getText().toLowerCase();
        String expectedAccountLoginText = "login to your account";
        sftAsrt.assertTrue(actualAccountLoginText.contains(expectedAccountLoginText));
    }

    @When("user enters correct email")
    public void userEntersCorrectEmail() throws IOException {
        String genEmail = configurations.fkGet("genEmail");
        login.email.sendKeys(genEmail);
    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() throws IOException {
        String genPassword = configurations.fkGet("genPassword");
        login.password.sendKeys(genPassword);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        login.loginButton.click();
    }
}