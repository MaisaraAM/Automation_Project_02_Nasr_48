package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D05_checkout {
    P01_register registration = new P01_register();
    P03_homepage homepage = new P03_homepage();
    P04_products products = new P04_products();
    P05_cart cart = new P05_cart();
    P06_checkout checkout = new P06_checkout();
    Faker fake = new Faker();
    SoftAssert sftAsrt = new SoftAssert();

    @Then("verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("cartURL"));
    }

    @When("user clicks 'Proceed To Checkout' button")
    public void userClicksProceedToCheckoutButton() {
        cart.checkoutButton.click();
    }

    @Then("verify the delivery address")
    public void verifyTheDeliveryAddress() throws IOException {
        sftAsrt.assertTrue(checkout.dlvrAdrsName.getText().contains(configurations.getFake("genFirstName")));
        sftAsrt.assertTrue(checkout.dlvrAdrsName.getText().contains(configurations.getFake("getLastName")));

        sftAsrt.assertEquals(checkout.dlvrAdrsAdrs1.getText(), configurations.getFake("genAddress1"));

        sftAsrt.assertTrue(checkout.dlvrAdrsCtStZip.getText().contains(configurations.getFake("genCity")));
        sftAsrt.assertTrue(checkout.dlvrAdrsCtStZip.getText().contains(configurations.getFake("genState")));
        sftAsrt.assertTrue(checkout.dlvrAdrsCtStZip.getText().contains(configurations.getFake("genZipcode")));

        sftAsrt.assertEquals(checkout.dlvrAdrsCntry.getText(), "New Zealand");

        sftAsrt.assertEquals(checkout.dlvrAdrsPhone.getText(), configurations.getFake("genMobileNum"));

        sftAsrt.assertAll();
    }

    @And("verify the billing address")
    public void verifyTheBillingAddress() throws IOException {
        sftAsrt.assertTrue(checkout.billAdrsName.getText().contains(configurations.getFake("genFirstName")));
        sftAsrt.assertTrue(checkout.billAdrsName.getText().contains(configurations.getFake("getLastName")));

        sftAsrt.assertEquals(checkout.billAdrsAdrs1.getText(), configurations.getFake("genAddress1"));

        sftAsrt.assertTrue(checkout.billAdrsCtStZip.getText().contains(configurations.getFake("genCity")));
        sftAsrt.assertTrue(checkout.billAdrsCtStZip.getText().contains(configurations.getFake("genState")));
        sftAsrt.assertTrue(checkout.billAdrsCtStZip.getText().contains(configurations.getFake("genZipcode")));

        sftAsrt.assertEquals(checkout.billAdrsCntry.getText(), "New Zealand");

        sftAsrt.assertEquals(checkout.billAdrsPhone.getText(), configurations.getFake("genMobileNum"));

        sftAsrt.assertAll();
    }

    @When("user clicks on 'Delete Account' button")
    public void userClicksOnDeleteAccountButton() {
        homepage.deleteAcntButton.click();
    }

    @Then("verify 'ACCOUNT DELETED!' is visible")
    public void verifyACCOUNTDELETEDIsVisible() {
        String actSuccessMsg = registration.acntDelMsg.getText().toLowerCase();
        String expSuccessMsg = "account deleted";
        sftAsrt.assertTrue(actSuccessMsg.contains(expSuccessMsg));

        Color successMsgColour = Color.fromString(registration.acntDelMsg.getCssValue("color"));
        sftAsrt.assertEquals(successMsgColour.asHex(), "#008000");

        sftAsrt.assertAll();
    }

    @And("user clicks 'Register-Login' button")
    public void userClicksRegisterLoginButton() {
        cart.checkoutRegisterButton.click();
    }

    @When("user clicks on 'Cart' button")
    public void userClicksOnCartButton() {
        homepage.cartPage.click();
    }

    @And("review the order")
    public void reviewTheOrder() {String actualProd1Name = products.product1.getText().toLowerCase();
        String expectedProd1Name = "blue top";
        sftAsrt.assertTrue(actualProd1Name.contains(expectedProd1Name));

        String actProd1Price = cart.prod1CartPrice.getText();
        String expProd1Price = "500";
        sftAsrt.assertTrue(actProd1Price.contains(expProd1Price));

        String actProd1Qnty = cart.prod1CartQnty.getText();
        sftAsrt.assertEquals(actProd1Qnty, "1");

        String actProd1Total = cart.prod1CartTotal.getText();
        String expProd1Total = "500";
        sftAsrt.assertTrue(actProd1Total.contains(expProd1Total));

        String actOrderTotal = checkout.orderTotal.getText();
        String expOrderTotal = "500";
        sftAsrt.assertTrue(actOrderTotal.contains(expOrderTotal));

        sftAsrt.assertAll();
    }

    @When("user enters description in comment text area")
    public void userEntersDescriptionInCommentTextArea() throws IOException {
        checkout.orderComment.sendKeys(configurations.getFake("orderComment1"));
    }

    @And("user clicks 'Place Order'")
    public void userClicksPlaceOrder() {
        checkout.placeOrder.click();
    }

    @And("user enters payment details: name on card")
    public void userEntersPaymentDetailsNameOnCard() throws IOException {
        checkout.nameOnCard.sendKeys(configurations.getFake("genFirstName"));
        checkout.nameOnCard.sendKeys(Keys.SPACE);
        checkout.nameOnCard.sendKeys(configurations.getFake("genLastName"));
    }

    @And("user enters card number")
    public void userEntersCardNumber() {
        String fkcardNum = fake.business().creditCardNumber();
        checkout.cardNumber.sendKeys(fkcardNum);
    }

    @And("user enters cvc")
    public void userEntersCvc() {
        checkout.cardCVC.sendKeys("678");
    }

    @And("user enters expiration date")
    public void userEntersExpirationDate() {
        checkout.expiryMon.sendKeys("06");
        checkout.expiryYear.sendKeys("2026");
    }

    @And("user clicks 'Pay and Confirm Order' button")
    public void userClicksPayAndConfirmOrderButton() {
        checkout.payOrder.click();
    }

    @Then("verify success message 'Your order has been placed successfully!' is visible")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfullyIsVisible() {
        String actSuccessMsg = checkout.orderPlacMsg.getText().toLowerCase();
        String expSuccessMsg = "your order has been placed successfully";
        sftAsrt.assertTrue(actSuccessMsg.contains(expSuccessMsg));

        Color successMsgColour = Color.fromString(checkout.orderPlacMsg.getCssValue("color"));
        sftAsrt.assertEquals(successMsgColour.asHex(), "#3c763d");

        Color successMsgBgColour = Color.fromString(checkout.orderPlacMsg.getCssValue("background-color"));
        sftAsrt.assertEquals(successMsgBgColour.asHex(), "#dff0d8");

        sftAsrt.assertAll();
    }
}