package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_products;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D06_categories {
    P04_products products = new P04_products();
    SoftAssert sftAsrt = new SoftAssert();

    @Given("categories are visible on left side bar")
    public void categoriesAreVisibleOnLeftSideBar() {
        sftAsrt.assertEquals(products.categText.getText().toLowerCase(), "category");

        sftAsrt.assertTrue(products.categPanels.isDisplayed());

        sftAsrt.assertAll();
    }

    @When("user clicks on 'Women' category")
    public void userClicksOnWomenCategory() {
        products.womenCateg.click();
    }

    @And("user clicks on any category link under 'Women' category")
    public void userClicksOnAnyCategoryLinkUnderWomenCategory() {
        products.dressCateg.click();
    }

    @Then("verify that category page is displayed")
    public void verifyThatCategoryPageIsDisplayed() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("categ1URL"));
    }

    @And("verify text 'WOMEN - DRESS PRODUCTS' is visible")
    public void verifyTextWOMENDRESSPRODUCTSIsVisible() {
        String actCategPageTitle = products.categPageTitle.getText().toLowerCase();
        String expCategPageTitle = "women - dress products";
        sftAsrt.assertTrue(actCategPageTitle.contains(expCategPageTitle));
    }

    @When("user clicks on any sub-category link of 'Men' category from left side bar")
    public void userClicksOnAnySubCategoryLinkOfMenCategoryFromLeftSideBar() {
        products.menCateg.click();
        products.jeansCateg.click();
    }

    @Then("verify user is navigated to that category page")
    public void verifyUserIsNavigatedToThatCategoryPage() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("categ6URL"));
    }

    @Then("verify that Brands are visible on left side bar")
    public void verifyThatBrandsAreVisibleOnLeftSideBar() {
        sftAsrt.assertTrue(products.brandPanel.isDisplayed());
    }

    @When("user clicks on any brand name")
    public void userClicksOnAnyBrandName() {
        products.brandPolo.click();
    }

    @Then("verify that user is navigated to brand page")
    public void verifyThatUserIsNavigatedToBrandPage() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("brand1URL"));
    }

    @And("brand products are displayed")
    public void brandProductsAreDisplayed() {
        String brand1PageTitle =products.brand1PageTitle.getText().toLowerCase();
        sftAsrt.assertTrue(brand1PageTitle.contains("polo"));
    }

    @When("user clicks on any other brand link on left side bar")
    public void userClicksOnAnyOtherBrandLinkOnLeftSideBar() {
        products.brandBiba.click();
    }

    @Then("verify that user is navigated to that brand page")
    public void verifyThatUserIsNavigatedToThatBrandPage() throws IOException {
        sftAsrt.assertEquals(driver.getCurrentUrl(), configurations.getConfig("brand2URL"));
    }

    @And("verify that user can see products")
    public void verifyThatUserCanSeeProducts() {
        String brand2PageTitle =products.brand2PageTitle.getText().toLowerCase();
        sftAsrt.assertTrue(brand2PageTitle.contains("biba"));
    }
}