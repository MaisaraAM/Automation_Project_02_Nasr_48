package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_products;
import org.example.pages.P05_cart;
import org.example.pages.P06_checkout;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D05_checkout {
    P04_products products = new P04_products();
    P05_cart cart = new P05_cart();
    P06_checkout checkout = new P06_checkout();
    SoftAssert sftAsrt = new SoftAssert();

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

    @And("review the order")
    public void reviewTheOrder() {String actualProd1Name = products.product1.getText().toLowerCase();
        String expectedProd1Name = "blue top";
        sftAsrt.assertTrue(actualProd1Name.contains(expectedProd1Name));

        String actProd1Price = cart.prod1CartPrice.getText();
        String expProd1Price = "500";
        sftAsrt.assertTrue(actProd1Price.contains(expProd1Price));

        int actProd1Qnty = cart.prod1CartQnty;
        sftAsrt.assertEquals(actProd1Qnty, 1);

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
    public void userEntersPaymentDetailsNameOnCard() {
    }

    @And("user enters card number")
    public void userEntersCardNumber() {
    }

    @And("user enters cvc")
    public void userEntersCvc() {
    }

    @And("user enters expiration date")
    public void userEntersExpirationDate() {
    }

    @And("user clicks 'Pay and Confirm Order' button")
    public void userClicksPayAndConfirmOrderButton() {
    }

    @Then("verify success message 'Your order has been placed successfully!' is visible")
    public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfullyIsVisible() {
    }
}