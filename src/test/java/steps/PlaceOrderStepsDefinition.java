package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class PlaceOrderStepsDefinition {

    public static WebDriver driver;

    @Given("Launch browser")
    public void launch_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("Navigate to url {string}")
    public void navigate_to_url(String string) {
        driver.navigate().to(string);
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @When("Add products to cart")
    public void add_products_to_cart() {
        driver.findElement(By.xpath("//a[contains(@data-product-id,'2')]")).click();
    }

    @When("Click 'Cart' button")
    public void click_chart_buton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();
    }

    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_displayed() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
    }

    @When("Click 'Proceed To Checkout' button")
    public void click_proceed_to_checkout() {
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
    }

    @When("Click 'Register Login' button")
    public void click_register_button() {
        driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]")).click();
    }

    @When("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).sendKeys("RRR");
        driver.findElement(By.xpath("//input[contains(@data-qa,'signup-email')]")).sendKeys("rrr1@one.lt");
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("123469");
        driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys("Roo");
        driver.findElement(By.xpath("//input[contains(@name,'last_name')]")).sendKeys("Uuuu");
        driver.findElement(By.xpath("//input[contains(@name,'address1')]")).sendKeys("Vil");
        driver.findElement(By.xpath("//option[contains(@value,'Australia')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'state')]")).sendKeys("New");
        driver.findElement(By.xpath("//input[contains(@name,'city')]")).sendKeys("City");
        driver.findElement(By.xpath("//input[contains(@name,'zipcode')]")).sendKeys("9874");
        driver.findElement(By.xpath("//input[contains(@name,'mobile_number')]")).sendKeys("+3706000000");
        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
    }

    @Then("Verify 'ACCOUNT CREATED!' and click 'Continue' button")
    public void verify_and_click_button() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created");
        driver.findElement(By.xpath("//a[contains(@data-qa,'continue-button')]")).click();
    }

    @Then("Verify ' Logged in as username' at top")
    public void verify_at_top() throws InterruptedException {
        driver.navigate().to("https://automationexercise.com/account_created");
        driver.findElement(By.xpath("//a[contains(@data-qa,'continue-button')]")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'RRR')]")).getText(), "RRR");
    }

    @Then("Click 'Cart' button2")
    public void click_chart_buton2() {
        driver.findElement(By.xpath("//a[contains(@href,'/view_cart')]")).click();
    }


    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'. Roo Uuuu')]")).getText(), ". Roo Uuuu");
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'Vil')]")).getText(), "Vil");
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'City New')]")).getText(), "City New 9874");
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'Australia')]")).getText(), "Australia");
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'+3706000000')]")).getText(), "+3706000000");

        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(@href,'/product_details/')]")).getText(), "Men Tshirt");
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(@class,'cart_quantity')]")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(@class,'cart_total_price')]")).getText(), "Rs. 400");
    }

    @Then("Enter description in comment text area and click 'Place Order'")
    public void enter_description_in_comment_text_area_and_click() {
        driver.findElement(By.xpath("//textarea[contains(@class,'form-control')]")).sendKeys("Deliver in 1 week please");
        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
    }

    @Then("Enter payment details")
    public void enter_payment_details() {
        driver.findElement(By.xpath("//input[contains(@name,'name_on_card')]")).sendKeys("RRRRRR UUUUUUUUU");
        driver.findElement(By.xpath("//input[contains(@name,'card_number')]")).sendKeys("123412341234");
        driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
        driver.findElement(By.xpath("//input[contains(@name,'expiry_month')]")).sendKeys("12");
        driver.findElement(By.xpath("//input[contains(@name,'expiry_year')]")).sendKeys("2030");
    }

    @Then("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_button() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("Verify success message 'Your order has been placed successfully!'")
    public void verify_success_message() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Order Placed");
    }

    @Then("Click 'Delete Account' button")
    public void click_delete_account(){
        driver.findElement(By.xpath("//a[contains(@href,'/delete_account')]")).click();
    }

    @Then("Verify ACCOUNT DELETED! and click Continue button")
    public void verify_account_deleted_and_click_continue_button() {
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).getText(), "ACCOUNT DELETED!");
    }
}