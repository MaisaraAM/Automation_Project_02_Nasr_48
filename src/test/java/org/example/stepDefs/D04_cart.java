package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;
import org.example.pages.P04_products;
import org.example.pages.P05_cart;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D04_cart {
    P03_homepage homepage = new P03_homepage();
    P04_products products = new P04_products();
    P05_cart cart = new P05_cart();
    SoftAssert sftAsrt = new SoftAssert();

    @And("user hovers over the first product and clicks 'Add to cart'")
    public void userHoversOverTheFirstProductAndClicksAddToCart() {
        products.addProd1ToCart.click();
    }

    @And("user clicks 'Continue Shopping' button")
    public void userClicksContinueShoppingButton() {
        products.contShopBtn.click();
    }

    @And("user hovers over the second product and clicks 'Add to cart'")
    public void userHoversOverTheSecondProductAndClicksAddToCart() {
        products.addProd2ToCart.click();
    }

    @And("user clicks 'View Cart' button")
    public void userClicksViewCartButton() {
        homepage.viewCart.click();
    }

    @Then("verify both products are added to cart")
    public void verifyBothProductsAreAddedToCart() {
        String actualProd1Name = products.product1.getText().toLowerCase();
        String expectedProd1Name = "blue top";
        sftAsrt.assertTrue(actualProd1Name.contains(expectedProd1Name));

        String actualProd2Name = products.product2.getText().toLowerCase();
        String expectedProd2Name = "men tshirt";
        sftAsrt.assertTrue(actualProd2Name.contains(expectedProd2Name));
    }

    @And("verify their prices, quantity, and total price")
    public void verifyTheirPricesQuantityAndTotalPrice() {
        String actProd1Price = cart.prod1CartPrice.getText();
        String expProd1Price = "500";
        sftAsrt.assertTrue(actProd1Price.contains(expProd1Price));

        String actProd2Price = cart.prod2CartPrice.getText();
        String expProd2Price = "400";
        sftAsrt.assertTrue(actProd2Price.contains(expProd2Price));

        int actProd1Qnty = cart.prod1CartQnty;
        sftAsrt.assertEquals(actProd1Qnty, 1);

        int actProd2Qnty = cart.prod2CartQnty;
        sftAsrt.assertEquals(actProd2Qnty, 1);

        String actProd1Total = cart.prod1CartTotal.getText();
        String expProd1Total = "500";
        sftAsrt.assertTrue(actProd1Total.contains(expProd1Total));

        String actProd2Total = cart.prod2CartTotal.getText();
        String expProd2Total = "400";
        sftAsrt.assertTrue(actProd2Total.contains(expProd2Total));
    }

    @When("user clicks 'View Product' for any product on homepage")
    public void userClicksViewProductForAnyProductOnHomepage() {
        products.product1.click();
    }

    @Then("verify product page is opened")
    public void verifyProductPageIsOpened() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
    }

    @When("user increases product quantity to {string}")
    public void userIncreasesProductQuantityTo(String prodQnty) {
        products.prodQnty.clear();
        products.prodQnty.sendKeys(prodQnty);
    }

    @And("user clicks 'Add to cart' button")
    public void userClicksAddToCartButton() {
        products.addProdQntyToCart.click();
    }

    @Then("verify that the product is displayed in cart page with exact quantity")
    public void verifyThatTheProductIsDisplayedInCartPageWithExactQuantity() {
        int actProd1Qnty = cart.prod1CartQnty;
        sftAsrt.assertEquals(actProd1Qnty, 4);
    }

    @Then("verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
    }

    @When("user clicks 'Proceed To Checkout' button")
    public void userClicksProceedToCheckoutButton() {
        cart.checkoutButton.click();
    }

    @And("user clicks 'Register-Login' button")
    public void userClicksRegisterLoginButton() {
        cart.checkoutRegisterButton.click();
    }
}