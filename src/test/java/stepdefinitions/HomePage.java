package stepdefinitions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {
	 WebDriver driver;

	 @Given("I launch the browser and navigate to the Urban Ladder homepage")
	    public void launch_browser_and_navigate_to_homepage() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.urbanladder.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @When("I should see the homepage displayed correctly")
	    public void verify_homepage_display() {
	        WebElement showHomepage = driver.findElement(By.xpath("//section[@class='header__topBar_sectionLeft']"));
	        assert showHomepage.isDisplayed();
	    }

	    @Then("I search for {string} and verify results")
	    public void search_for_product(String product) throws InterruptedException {
	        WebElement search = driver.findElement(By.id("search"));
	        search.sendKeys(product);

	        WebElement clickSearch = driver.findElement(By.id("search_button"));
	        clickSearch.click();

	        WebElement closeModal = driver.findElement(By.cssSelector("a.close-reveal-modal.hide-mobile"));
	        closeModal.click();

	        Thread.sleep(3000); 
	    }

	    @When("I should see search results related to {string}")
	    public void verify_search_results(String product) {
	        WebElement resultsSection = driver.findElement(By.xpath("//span[@class='key']"));
	        assert resultsSection.isDisplayed();
	    }

	    @When("I apply a filter and verify updated search results")
	    public void apply_filter_and_verify_results() {
	        driver.findElement(By.xpath("(//div[@class='gname'])[1]")).click();
	        driver.findElement(By.xpath("//label[@for=\"filters_primary_category_Leatherette_Sofa_Sets\"]")).click();
	        driver.findElement(By.xpath("//img[@title='Adelaide Compact Leatherette Sofa (Cream)']")).click();

	    }

	    @When("I add a product to the cart")
	    public void add_product_to_cart() {
	        driver.findElement(By.xpath("(//button[normalize-space()='Add to Cart'])[1]")).click();
	        driver.findElement(By.xpath("(//span[normalize-space()='1. Cart'])[1]")).click();

	        WebElement cartConfirmation = driver.findElement(By.xpath("(//span[normalize-space()='1. Cart'])[1]"));
	        assert cartConfirmation.isDisplayed();
	    }

	    @Then("The product should be added to the cart successfully")
	    public void verify_product_in_cart() {
	        WebElement cartIcon = driver.findElement(By.xpath("//div[@id='wrapper']//img[1]"));
	        assert cartIcon.isDisplayed();
	    }

	    @When("I click on the Checkout button")
	    public void click_checkout() {
	        driver.findElement(By.xpath("(//button[@id='checkout-link'])[1]")).click();
	    }

	    @When("I enter valid dummy shipping details")
	    public void enter_shipping_details() {
	        driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("shubhamyetonde865@gmail.com");
	        driver.findElement(By.xpath("//input[@placeholder='PIN Code']")).sendKeys("565612");
	        driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("HSR Masai School, Bengaluru");
	        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Shubham");
	        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Yetonde");
	        driver.findElement(By.xpath("//input[@placeholder='Enter 10 digit mobile number']")).sendKeys("8956545953");
	        driver.findElement(By.xpath("//input[@value='Save and Continue']")).click();
	    }

	    @Then("The checkout page should load successfully")
	    public void verify_checkout_page() {
	        WebElement shippingForm = driver.findElement(By.xpath("(//div[@class='shipping_address'])[1]"));
	        assert shippingForm.isDisplayed();
	    }
	    
}
