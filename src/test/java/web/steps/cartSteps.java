package web.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.page.cartPage;
import web.page.loginPage;
import web.page.productPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class cartSteps {

    WebDriver driver;
    cartPage cart;
    loginPage login;
    productPage product;

    @Before("@cart")
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // headless mode (wajib di CI)
        options.addArguments("--no-sandbox"); // bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // avoid limited resource in /dev/shm
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        cart = new cartPage(driver);
        login = new loginPage(driver);
        product = new productPage(driver);
    }

   @Before("@cart")
    public void setLoginCart() {
        driver.get("https://www.saucedemo.com/");
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/inventory.html"));

        product.clickAddToCartButton("Sauce Labs Backpack");

        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Given("the user is in the Cart page, with {string} item in the cart")
    public void item_in_the_cart(String itemCount) {
        String actual = cart.cartItemCount();
        assertEquals(itemCount, actual);
    }

    @When("the user click the Checkout button")
    public void click_checkout_button() {
        cart.clickCheckoutButton();
    }

    @Then("the user will be redirected to the first Checkout page")
    public void redirected_to_checkout_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
