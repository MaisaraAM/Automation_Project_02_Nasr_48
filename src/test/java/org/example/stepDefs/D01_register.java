package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_register {
    P01_register registration = new P01_register();
    Faker fake = new Faker();
    SoftAssert sftAsrt = new SoftAssert();

    @When("user goes to register page")
    public void userGoesToRegisterPage() throws InterruptedException {
        boolean homePageVisible = registration.homePageLoaded.isDisplayed();
        sftAsrt.assertTrue(homePageVisible);

        registration.goToRegisterPage.click();
        Thread.sleep(500);

        String actualUserSignupText = registration.newUserSignup.getText().toLowerCase();
        String expectedUserSignupText = "new user signup";
        sftAsrt.assertTrue(actualUserSignupText.contains(expectedUserSignupText));
    }

    @And("user enters username")
    public void userEntersUsername() throws IOException {
        String fkUsername = fake.name().username();
        registration.username.sendKeys(fkUsername);
        configurations.fkSet("genUsername", fkUsername);
    }

    @And("user enters email")
    public void userEntersEmail() throws IOException {
        String fkEmail = fake.internet().emailAddress();
        registration.email.sendKeys(fkEmail);
        configurations.fkSet("genEmail", fkEmail);
    }

    @And("user clicks signup button")
    public void userClicksSignupButton() throws InterruptedException {
        registration.signupButton.click();
        Thread.sleep(500);

        String actualCrtAcntFormText = registration.createAccountForm.getText().toLowerCase();
        String expectedCrtAcntFornText = "enter account information";
        sftAsrt.assertTrue(actualCrtAcntFormText.contains(expectedCrtAcntFornText));
    }

    @And("user enters password")
    public void userEntersPassword() {
    }

    @And("user enters date of birth")
    public void userEntersDateOfBirth() {
    }

    @And("user selects newsletter checkbox")
    public void userSelectsNewsletterCheckbox() {
    }

    @And("user selects offers checkbox")
    public void userSelectsOffersCheckbox() {
    }

    @And("user enters first name")
    public void userEntersFirstName() {
    }

    @And("user enters last name")
    public void userEntersLastName() {
    }

    @And("user enters address")
    public void userEntersAddress() {
    }

    @And("user enters country")
    public void userEntersCountry() {
    }

    @And("user enters state")
    public void userEntersState() {
    }

    @And("user enters city")
    public void userEntersCity() {
    }

    @And("user enters zipcode")
    public void userEntersZipcode() {
    }

    @And("user enters mobile number")
    public void userEntersMobileNumber() {
    }

    @And("user clicks create account button")
    public void userClicksCreateAccountButton() {
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
    }
}