package features;

import cucumber.api.PendingException;
import utils.AutomationConstants;
import utils.BrowserFactory;
import utils.VerifyUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.*;

import java.util.Map;

/**
 * Created by sriramangajala on 02/07/15.
 */


public class FuncStepDef {

    public WebDriver driver;
    public LoginPage loginPage;// = new LoginPage();
    private DashboardPage dashboardPage;
    private SearchResultPage searchResultPage;
    private Basketpage basketpage;
    ExtentReports report;
    ExtentTest logger;
    ListOfProducts listOfProducts;
    ProductPage productPage;
    PaymentPage paymentPage;
    public MapLogin mapLogin;
    public HomePage homePage;



    @Before
    public void start()
    {
        driver = BrowserFactory.getDriver();
    }




    @Given("^I am logged in user$")
    public void i_am_logged_in_user() throws Throwable {
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD);

    }


    @Then("^the Subject should be \"(.*?)\"$")
    public void the_Subject_should_be(String arg1) throws Throwable {
        Assert.assertTrue(dashboardPage.checkHeader(arg1));
    }

    @Then("^the Subject should be \"(.*?)\" and fail$")
    public void the_Subject_should_be_fail(String arg1) throws Throwable {
        Assert.assertFalse(dashboardPage.checkHeader(arg1));
    }


    @Given("^user open a browser$")
    public void user_open_a_browser() throws Throwable {

    }

    @And("^opens the url for \"([^\"]*)\" brand$")
    public void opens_the_url_for_brand(String brand) throws Throwable {

        if(brand.equalsIgnoreCase("Armstrong Auto"))
        {
            driver.get(AutomationConstants.URL);
        }
    }

    @Then("^the page should be opened$")
    public void the_page_should_be_opened() throws Throwable {

        dashboardPage = new DashboardPage();
    }

    @And("^the brand name should be shown as \"([^\"]*)\"$")
    public void the_brand_name_should_be_shown_brand_name_in_header_as(String header) throws Throwable {

        VerifyUtils.True("Checking if user can see header", dashboardPage.checkHeader(header));
    }

    @And("^show the below elements$")
    public void show_the_below_elements(DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMap(String.class,String.class);
        dashboardPage.checkElements(data);

    }

    @Then("^a header with name \"(.*?)\"$")
    public void a_header_with_name(String header) throws Throwable {
        VerifyUtils.True("Checking the header is "+header, dashboardPage.getHeader(header));
    }

    @Then("^a button with name \"(.*?)\" is shown$")
    public void a_button_with_name_is_shown(String buttontext) throws Throwable {

        VerifyUtils.True("Checking the button with text is "+buttontext, dashboardPage.getButton(buttontext));
    }

    @When("^(?:open|close) the ham burger menu$")
    public void open_the_ham_burger_menu() throws Throwable {
        dashboardPage = new DashboardPage();
        dashboardPage.openHamBurgerMenu();

    }

    @Then("^I should see the following option$")
    public void I_should_see_the_following_option(DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMap(String.class,String.class);
        dashboardPage.checkElements(data);
    }

    @When("^he open an all the shops$")
    public void he_open_an_all_the_shops() throws Throwable {
        dashboardPage = new DashboardPage();
        dashboardPage.openAllShops();

    }

    String branch;
    @Then("^the branch \"(.*?)\" should be shown$")
    public void he_the_branch_should_be_shown(String branch) throws Throwable {

        dashboardPage.checkBranchIsShown(branch);
        this.branch = branch;
    }

    @Then("^he opens the branch$")
    public void he_opens_the_branch() throws Throwable {
        dashboardPage.openTheBranch(branch);

    }

    @Then("^the details of the branch should be shown$")
    public void the_details_of_the_branch_should_be_shown() throws Throwable {

        dashboardPage.checkBranchText(branch);
    }

    @Given("^user is in home page$")
    public void user_is_in_home_page() throws Throwable {

        dashboardPage = new DashboardPage();
        dashboardPage.checkHeader("MATCHESFASHION.COM");

    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchKeyword) throws Throwable {

        logger.log(LogStatus.INFO,"I search for ", searchKeyword);
        dashboardPage = new DashboardPage();
        dashboardPage.searchWithKeyword(searchKeyword);
        Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains("Sorry, we couldn't find any results matching"));

    }


    @And("^added an item to the basket with title \"([^\"]*)\"$")
    public void added_an_item_to_the_basket_with_title(String title) throws Throwable {
        searchResultPage = new SearchResultPage();
        searchResultPage.addFirstItemIntoTheBasket();
    }

    @Then("^an item should be available in basket$")
    public void an_item_should_be_available_in_basket() throws Throwable {
        logger.log(LogStatus.INFO,"an item should be available in basket");
        basketpage = new Basketpage();
        basketpage.checkItemIsAdded();
        logger.log(LogStatus.PASS,"an item should be available in basket");


    }








    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }



    }


    @When("^he navigates to \"([^\"]*)\" section$")
    public void he_navigates_to_section(String navigationLinks) throws Throwable {
        dashboardPage.openNavigationLinks(navigationLinks);
    }

    @And("^selects the product with title \"([^\"]*)\"$")
    public void selects_the_product_with_title(String product) throws Throwable {
        listOfProducts = new ListOfProducts();
        productPage = listOfProducts.openProduct(product);

    }

    @And("^adds the item to the basket$")
    public void adds_the_item_to_the_basket() throws Throwable {
        productPage.selectDefaultOptionsAndAddItemToBasket();

    }

    @Then("^opens continue till the payment$")
    public void opens_continue_till_the_payment() throws Throwable {
        paymentPage = dashboardPage.gotoPaymentScreen();
    }

    @And("^pay with a new card$")
    public void pay_with_a_new_card() throws Throwable {
        paymentPage.paywithDefaultCard();
    }

    @Then("^payment should be successful$")
    public void payment_should_be_successful() throws Throwable {
        paymentPage.checkNoErrorMessagesShown();
    }

    @When("^he opens the \"([^\"]*)\" section$")
    public void he_opens_the_section(String link) throws Throwable {
        dashboardPage.openurl(link);
    }

    @Given("^user is logged in$")
    public void user_is_logged_in() throws Throwable {

    }

    @Given("^user logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logged_in_with_and(String username, String password) throws Throwable {

        System.out.println(username + password);

        mapLogin = new MapLogin();

        homePage = mapLogin.loginToApplication(username,password);


    }

    @Then("^he should be in home page$")
    public void he_should_be_in_home_page() throws Throwable {

        homePage.checkUserIsInHomePage();

    }

//    @Then("^i enter integer (\\d+)$")
//    public void i_enter_integer(int arg1) throws Throwable {
//
//    }

    @Then("^i enter integer \"(\\d+)\"$")
    public void i_enter_integer(int arg1) throws Throwable {

    }

    @When("^he search for a \"([^\"]*)\" address$")
    public void he_search_for_a_address(String text) throws Throwable {

        homePage.searchForText(text);
    }


}
