package features;

import utils.AutomationConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductPage;

/**
 * Created by sriramangajala on 13/03/16.
 */
public class SriramStepDefs {

   // WebDriver driver = BrowserFactory.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage;
    ProductPage productPage;

    @Given("^admin is in dashboard CSB$")
    public void admin_is_in_dashboard_CSB() {
        dashboardPage = loginPage.loginHBL(AutomationConstants.USERNAME, AutomationConstants.PASSWORD);
    }



    @When("^he navigates to \"(.*?)\" page$")
    public void he_navigates_to_page(String page) throws Throwable {

        dashboardPage.navigate(page);

    }

    @Then("^the page title should be \"(.*?)\"$")
    public void the_page_title_should_be(String title) throws Throwable {

        dashboardPage.checkTitle(title);

    }

    @Then("^he should see atleast (\\d+) product from the list$")
    public void he_should_see_atleast_product_from_the_list(int count) throws Throwable {
        productPage = new ProductPage();
        productPage.checkNumberOfProducts(count);

    }
}
