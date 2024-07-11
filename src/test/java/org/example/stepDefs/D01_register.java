package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P03_homepage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_register {
    P01_register registration = new P01_register();
    P03_homepage homepage = new P03_homepage();
    Faker fake = new Faker();
    SoftAssert sftAsrt = new SoftAssert();

    @Given("homepage is visible successfully")
    public void homepageIsVisibleSuccessfully() {
        boolean homePageVisible = homepage.homePageLoaded.isDisplayed();
        sftAsrt.assertTrue(homePageVisible);
    }

    @When("user clicks on 'Signup-Login' button")
    public void userClicksOnSignupLoginButton() {
        homepage.goToRegisterPage.click();
    }

    @Then("verify 'New User Signup!' is visible")
    public void verifyNewUserSignupIsVisible() {
        String actualUserSignupText = registration.newUserSignup.getText().toLowerCase();
        String expectedUserSignupText = "new user signup";
        sftAsrt.assertTrue(actualUserSignupText.contains(expectedUserSignupText));
    }

    @When("user enters username")
    public void userEntersUsername() throws IOException {
        String fkUsername = fake.name().username();
        registration.username.sendKeys(fkUsername);
        configurations.setFake("genUsername", fkUsername);
    }

    @And("user enters email")
    public void userEntersEmail() throws IOException {
        String fkEmail = fake.internet().emailAddress();
        registration.email.sendKeys(fkEmail);
        configurations.setFake("genEmail", fkEmail);
    }

    @And("user clicks signup button")
    public void userClicksSignupButton() {
        registration.signupButton.click();
    }

    @Then("verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void verifyThatEnterAccountInformationIsVisible() {
        String actualCrtAcntFormText = registration.createAccountForm.getText().toLowerCase();
        String expectedCrtAcntFormText = "enter account information";
        sftAsrt.assertTrue(actualCrtAcntFormText.contains(expectedCrtAcntFormText));
    }

    @When("user enters password")
    public void userEntersPassword() throws IOException {
        String fkPassword = fake.internet().password();
        registration.password.sendKeys(fkPassword);
        configurations.setFake("genPassword", fkPassword);
    }

    @And("user enters date of birth")
    public void userEntersDateOfBirth() {
        Select slctDay = new Select(registration.dobDay);
        slctDay.selectByValue("1");

        Select slctMon = new Select(registration.dobMon);
        slctMon.selectByValue("1");

        Select slctYr = new Select(registration.dobYr);
        slctYr.selectByValue("2000");
    }

    @And("user selects newsletter checkbox")
    public void userSelectsNewsletterCheckbox() {
        registration.newsletter.click();
    }

    @And("user selects offers checkbox")
    public void userSelectsOffersCheckbox() {
        registration.offers.click();
    }

    @And("user enters first name")
    public void userEntersFirstName() throws IOException {
        String fkFirstName = fake.name().firstName();
        registration.fName.sendKeys(fkFirstName);
        configurations.setFake("genFirstName", fkFirstName);
    }

    @And("user enters last name")
    public void userEntersLastName() throws IOException {
        String fkLastName = fake.name().lastName();
        registration.lName.sendKeys(fkLastName);
        configurations.setFake("getLastName", fkLastName);
    }

    @And("user enters address")
    public void userEntersAddress() throws IOException {
        String fkAddress1 = fake.address().streetAddress();
        registration.address1.sendKeys(fkAddress1);
        configurations.setFake("genAddress1", fkAddress1);
    }

    @And("user enters country")
    public void userEntersCountry() {
        Select slctCntry = new Select(registration.country);
        slctCntry.selectByValue("New Zealand");
    }

    @And("user enters state")
    public void userEntersState() throws IOException {
        String fkState = fake.address().state();
        registration.state.sendKeys(fkState);
        configurations.setFake("genState", fkState);
    }

    @And("user enters city")
    public void userEntersCity() throws IOException {
        String fkCity = fake.address().city();
        registration.city.sendKeys(fkCity);
        configurations.setFake("genCity", fkCity);
    }

    @And("user enters zipcode")
    public void userEntersZipcode() throws IOException {
        String fkZipcode = fake.address().zipCode();
        registration.zipcode.sendKeys(fkZipcode);
        configurations.setFake("genZipcode", fkZipcode);
    }

    @And("user enters mobile number")
    public void userEntersMobileNumber() throws IOException {
        String fkMobileNum = fake.phoneNumber().cellPhone();
        registration.mobileNum.sendKeys(fkMobileNum);
        configurations.setFake("genMobileNum", fkMobileNum);
    }

    @And("user clicks create account button")
    public void userClicksCreateAccountButton() {
        registration.createAccountButton.click();
    }

    @Then("verify that 'ACCOUNT CREATED!' is visible")
    public void verifyThatAccountCreatedIsVisible() {
        boolean sucsMsg = registration.successMsg.isDisplayed();
        sftAsrt.assertTrue(sucsMsg);

        Color successMsgColour = Color.fromString(registration.successMsg.getCssValue("color"));
        sftAsrt.assertEquals(successMsgColour.asHex(), "#008000");

        sftAsrt.assertAll();
    }

    @When("user clicks continue button")
    public void userClicksContinueButton() {
        registration.continueButton.click();
    }

    @Then("verify that 'Logged in as username' is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() throws IOException {
        String genUsername = configurations.getFake("genUsername");
        String actualUsername = homepage.userAccount.getText();
        sftAsrt.assertTrue(actualUsername.contains(genUsername));
    }
}