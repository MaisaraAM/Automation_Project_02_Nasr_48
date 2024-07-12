package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;
import org.example.pages.P04_products;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D03_viewProducts {
    P03_homepage homepage = new P03_homepage();
    P04_products products = new P04_products();
    SoftAssert sftAsrt = new SoftAssert();

    @When("user clicks on 'Products' button")
    public void userClicksOnProductsButton() {
        homepage.productsPage.click();
    }

    @Then("verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
    }

    @And("the products list is visible")
    public void theProductsListIsVisible() {
        String actualProductsPageTitle = products.productsListTitle.getText().toLowerCase();
        String expectedProductsPageTitle = "all products";
        sftAsrt.assertTrue(actualProductsPageTitle.contains(expectedProductsPageTitle));

        sftAsrt.assertEquals(products.productsList.size(), 34);

        sftAsrt.assertAll();
    }

    @When("user click on 'View Product' of first product")
    public void userClickOnViewProductOfFirstProduct() {
        products.product1.click();
    }

    @Then("user is landed to product detail page")
    public void userIsLandedToProductDetailPage() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
    }

    @And("verify that product details are visible")
    public void verifyThatProductDetailsAreVisible() {
        String actualProdName = products.product1Name.getText().toLowerCase();
        String expectedProdName = "blue top";
        sftAsrt.assertTrue(actualProdName.contains(expectedProdName));

        String actualProdCateg = products.product1Category.getText().toLowerCase();
        String expectedProdCateg = "women";
        sftAsrt.assertTrue(actualProdCateg.contains(expectedProdCateg));

        String actualProdPrice = products.product1Price.getText();
        String expectedProdPrice = "500";
        sftAsrt.assertTrue(actualProdPrice.contains(expectedProdPrice));

        String actualProdAvail = products.product1Availability.getText().toLowerCase();
        String expectedProdAvail = "in stock";
        sftAsrt.assertTrue(actualProdAvail.contains(expectedProdAvail));

        String actualProdCond = products.product1Condition.getText().toLowerCase();
        String expectedProdCond = "new";
        sftAsrt.assertTrue(actualProdCond.contains(expectedProdCond));

        String actualProdBrand = products.product1Brand.getText().toLowerCase();
        String expectedProdBrand = "polo";
        sftAsrt.assertTrue(actualProdBrand.contains(expectedProdBrand));

        sftAsrt.assertAll();
    }

    @When("user enters product name in search input")
    public void userEntersProductNameInSearchInput() throws IOException {
        String searchQuery = configurations.getConfig("searchQuery");
        products.searchField.sendKeys(searchQuery);
    }

    @And("user clicks search button")
    public void userClicksSearchButton() {
        products.searchButton.click();
    }

    @Then("verify 'SEARCHED PRODUCTS' is visible")
    public void verifySearchedProductsIsVisible() {
        String actualProdSearchTitle = products.searchResults.getText().toLowerCase();
        String expectedProdSearchTitle = "searched products";
        sftAsrt.assertTrue(actualProdSearchTitle.contains(expectedProdSearchTitle));
    }

    @And("verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() throws IOException {
        for (WebElement productName : products.productSeachList) {
            String searchQuery = configurations.getConfig("searchQuery");
            String prodName = productName.getText().toLowerCase();
            sftAsrt.assertTrue(prodName.contains(searchQuery));
        }
    }
}