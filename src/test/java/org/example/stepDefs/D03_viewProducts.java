package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D03_viewProducts {
    P03_homepage homepage = new P03_homepage();
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
        String actualProductsPageTitle = homepage.productsListTitle.getText().toLowerCase();
        String expectedProductsPageTitle = "all products";
        sftAsrt.assertTrue(actualProductsPageTitle.contains(expectedProductsPageTitle));

        sftAsrt.assertEquals(homepage.productsList.size(), 34);
    }

    @When("user click on 'View Product' of first product")
    public void userClickOnViewProductOfFirstProduct() {
        homepage.product1.click();
    }

    @Then("user is landed to product detail page")
    public void userIsLandedToProductDetailPage() {
        sftAsrt.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
    }

    @And("verify that product details are visible")
    public void verifyThatProductDetailsAreVisible() {
        String actualProdName = homepage.product1Name.getText().toLowerCase();
        String expectedProdName = "blue top";
        sftAsrt.assertTrue(actualProdName.contains(expectedProdName));

        String actualProdCateg = homepage.product1Category.getText().toLowerCase();
        String expectedProdCateg = "women";
        sftAsrt.assertTrue(actualProdCateg.contains(expectedProdCateg));

        String actualProdPrice = homepage.product1Price.getText().toLowerCase();
        String expectedProdPrice = "500";
        sftAsrt.assertTrue(actualProdPrice.contains(expectedProdPrice));

        String actualProdAvail = homepage.product1Availability.getText().toLowerCase();
        String expectedProdAvail = "in stock";
        sftAsrt.assertTrue(actualProdAvail.contains(expectedProdAvail));

        String actualProdCond = homepage.product1Condition.getText().toLowerCase();
        String expectedProdCond = "new";
        sftAsrt.assertTrue(actualProdCond.contains(expectedProdCond));

        String actualProdBrand = homepage.product1Brand.getText().toLowerCase();
        String expectedProdBrand = "polo";
        sftAsrt.assertTrue(actualProdBrand.contains(expectedProdBrand));
    }

    @When("user enters product name in search input")
    public void userEntersProductNameInSearchInput() {
        homepage.searchField.sendKeys("jeans");
    }

    @And("user clicks search button")
    public void userClicksSearchButton() {
        homepage.searchButton.click();
    }

    @Then("verify 'SEARCHED PRODUCTS' is visible")
    public void verifySearchedProductsIsVisible() {
        String actualProdSearchTitle = homepage.searchResults.getText().toLowerCase();
        String expectedProdSearchTitle = "searched products";
        sftAsrt.assertTrue(actualProdSearchTitle.contains(expectedProdSearchTitle));
    }

    @And("verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        for (WebElement productName : homepage.productSeachList) {
            String prodName = productName.getText().toLowerCase();
            sftAsrt.assertTrue(prodName.contains("jeans"));
        }
    }
}