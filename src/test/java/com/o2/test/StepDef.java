package com.o2.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
    SmokeTest smokeTest =new SmokeTest();
    @Given("^as a O(\\d+) customer$")
    public void as_a_O_customer(int arg1) {
smokeTest.phones("samsung");
    }

    @When("^i want to open the website and click shop$")
    public void i_want_to_open_the_website_and_click_shop()  {
        System.out.println("hi");
        smokeTest.paymentOption();
        smokeTest.filterOption();
        smokeTest.sortOption();

    }

    @When("^type the product name called \"([^\"]*)\"$")
    public void type_the_product_name_called(String arg1) {
        System.out.println("hello");
    }

    @Then("^so that i can view the respective pages$")
    public void so_that_i_can_view_the_respective_pages() {
        System.out.println("welcome");
    }

}
