package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_products;
import org.example.pages.P05_cart;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D04_cart {
    P04_products products = new P04_products();
    P05_cart cart = new P05_cart();
    SoftAssert sftAsrt = new SoftAssert();

    @And("user hovers over the first product and clicks 'Add to cart'")
    public void userHoversOverTheFirstProductAndClicksAddToCart() {
        products.addProd1ToCart.click();
    }

    @And("user clicks 'Continue Shopping' button")
    public void userClicksContinueShoppingButton() throws InterruptedException {
        Thread.sleep(300);
        products.contShopBtn.click();
    }

    @And("user hovers over the second product and clicks 'Add to cart'")
    public void userHoversOverTheSecondProductAndClicksAddToCart() {
        products.addProd2ToCart.click();
    }

    @And("user clicks 'View Cart' button")
    public void userClicksViewCartButton() throws InterruptedException {
        Thread.sleep(300);
        products.viewCart.click();
    }

    @Then("verify both products are added to cart")
    public void verifyBothProductsAreAddedToCart() {
        String actProd1Name = products.product1.getText().toLowerCase();
        String expProd1Name = "blue top";
        sftAsrt.assertTrue(actProd1Name.contains(expProd1Name));

        String actProd2Name = products.product2.getText().toLowerCase();
        String expProd2Name = "men tshirt";
        sftAsrt.assertTrue(actProd2Name.contains(expProd2Name));

        sftAsrt.assertAll();
    }

    @And("verify their prices, quantity, and total price")
    public void verifyTheirPricesQuantityAndTotalPrice() {
        String actProd1Price = cart.prod1CartPrice.getText();
        String expProd1Price = "500";
        sftAsrt.assertTrue(actProd1Price.contains(expProd1Price));

        String actProd2Price = cart.prod2CartPrice.getText();
        String expProd2Price = "400";
        sftAsrt.assertTrue(actProd2Price.contains(expProd2Price));

        String actProd1Qnty = cart.prod1CartQnty.getText();
        sftAsrt.assertEquals(actProd1Qnty, "1");

        String actProd2Qnty = cart.prod2CartQnty.getText();
        sftAsrt.assertEquals(actProd2Qnty, "1");

        String actProd1Total = cart.prod1CartTotal.getText();
        String expProd1Total = "500";
        sftAsrt.assertTrue(actProd1Total.contains(expProd1Total));

        String actProd2Total = cart.prod2CartTotal.getText();
        String expProd2Total = "400";
        sftAsrt.assertTrue(actProd2Total.contains(expProd2Total));

        sftAsrt.assertAll();
    }

    @When("user clicks 'View Product' for any product on homepage")
    public void userClicksViewProductForAnyProductOnHomepage() {
        products.product1.click();
    }

    @Then("verify product page is opened")
    public void verifyProductPageIsOpened() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("product1URL"));
    }

    @When("user increases product quantity to {string}")
    public void userIncreasesProductQuantityTo(String prodQnty) {
        products.prodQnty.clear();
        products.prodQnty.sendKeys(prodQnty);
    }

    @And("user clicks 'Add to cart' button")
    public void userClicksAddToCartButton() throws InterruptedException {
        Thread.sleep(300);
        products.addProdQntyToCart.click();
    }

    @Then("verify that the product is displayed in cart page with exact quantity")
    public void verifyThatTheProductIsDisplayedInCartPageWithExactQuantity() {
        String actProd1Name = products.product1.getText().toLowerCase();
        String expProd1Name = "blue top";
        sftAsrt.assertTrue(actProd1Name.contains(expProd1Name));

        String actProd1Qnty = cart.prod1CartQnty.getText();
        sftAsrt.assertEquals(actProd1Qnty, "4");

        sftAsrt.assertAll();
    }
}