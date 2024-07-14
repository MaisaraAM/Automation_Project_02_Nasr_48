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
    public void verifyUserIsNavigatedToAllProductsPageSuccessfully() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("productsURL"));
    }

    @And("the products list is visible")
    public void theProductsListIsVisible() {
        String actProductsPageTitle = products.productsListTitle.getText().toLowerCase();
        String expProductsPageTitle = "all products";
        sftAsrt.assertTrue(actProductsPageTitle.contains(expProductsPageTitle));

        sftAsrt.assertEquals(products.productsList.size(), 34);

        sftAsrt.assertAll();
    }

    @When("user click on 'View Product' of first product")
    public void userClickOnViewProductOfFirstProduct() {
        products.product1.click();
    }

    @Then("user is landed to product detail page")
    public void userIsLandedToProductDetailPage() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("product1URL"));
    }

    @And("verify that product details are visible")
    public void verifyThatProductDetailsAreVisible() {
        String actProdName = products.product1Name.getText().toLowerCase();
        String expProdName = "blue top";
        sftAsrt.assertTrue(actProdName.contains(expProdName));

        String actProdCateg = products.product1Category.getText().toLowerCase();
        String expProdCateg = "women > tops";
        sftAsrt.assertTrue(actProdCateg.contains(expProdCateg));

        String actProdPrice = products.product1Price.getText();
        String expProdPrice = "500";
        sftAsrt.assertTrue(actProdPrice.contains(expProdPrice));

        String actProdAvail = products.product1Availability.getText().toLowerCase();
        String expProdAvail = "in stock";
        sftAsrt.assertTrue(actProdAvail.contains(expProdAvail));

        String actProdCond = products.product1Condition.getText().toLowerCase();
        String expProdCond = "new";
        sftAsrt.assertTrue(actProdCond.contains(expProdCond));

        String actProdBrand = products.product1Brand.getText().toLowerCase();
        String expProdBrand = "polo";
        sftAsrt.assertTrue(actProdBrand.contains(expProdBrand));

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
        String actProdSearchTitle = products.searchResults.getText().toLowerCase();
        String expProdSearchTitle = "searched products";
        sftAsrt.assertTrue(actProdSearchTitle.contains(expProdSearchTitle));
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