package pages;

import utils.CommonUtils;
import utils.VerifyUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by sriramangajala on 02/07/15.
 */
public class DashboardPage extends BasePage {

    static Logger LOGGER = Logger.getLogger(DashboardPage.class);
    PaymentPage paymentPage;


    @FindBy(how = How.CLASS_NAME, using = "logo")
    public WebElement header;

    @FindBy(how = How.ID, using = "Subject")
    public WebElement Subject;

    @FindBy(how = How.CLASS_NAME, using = "hamburger_button")
    public WebElement hamburger_button;

    @FindBy(how = How.ID, using = "")
    public WebElement editableContent;

    @FindBy(how = How.CSS, using = "span.header_links.shop_link")
    public WebElement shop_button;

    @FindBy(how = How.CSS, using = "span.header_links.search_link")
    public WebElement search_button;

    @FindBy(how = How.LINK_TEXT, using = "Show all shops")
    public WebElement Show_all_shops;

    @FindBy(how = How.NAME, using = "search-keywords")
    public WebElement keyword_input_textbox;



    public DashboardPage() {

        PageFactory.initElements(driver, this);

    }


    public void enterBody(String body) {

        driver.switchTo().frame("iframeCommonBody");
        editableContent.sendKeys(body);
        driver.switchTo().defaultContent();

    }

    public void sendMessage() {
        ((JavascriptExecutor) driver).executeScript("checkLimitBeforeSend('/web_com/SendMessage?', 'send')");
//        driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
    }

    public boolean checkHeader(String message) {
        return header.getText().contains(message);
    }


    public boolean getHeader(String header) {
        return this.header.getText().contains(header);
    }

    public boolean getButton(String buttontext) {
        List<WebElement> elements = driver.findElements(By.tagName("button"));

        for (WebElement element : elements) {
            try {
                element.findElement(By.tagName("span")).getText().contains(buttontext);
                return true;
            } catch (Exception e) {
                //ignore
            }
        }

        return false;
    }

    public void openHamBurgerMenu() {
        hamburger_button.click();
    }

    public void openAllShops() {
        shop_button.click();
        CommonUtils.sleep(3);
        Show_all_shops.click();

    }

    public void checkBranchIsShown(String branch) {
        VerifyUtils.True("Checking that the branch " + branch + " is available", CommonUtils.isElementPresent(By.linkText(branch)));
    }

    public void openTheBranch(String branch) {
        driver.findElement(By.linkText(branch)).click();
    }

    public void checkBranchText(String branch) {
        VerifyUtils.ContainsTrue("Checking the branch details are shown " + branch, CommonUtils.getVisibleText(), "John Lewis " + branch);
    }


    public void searchWithKeyword(String keyword)
    {
        //click on search icon
        search_button.click();
        //enter the product name
        CommonUtils.sleep(2);

        keyword_input_textbox.clear();
        keyword_input_textbox.sendKeys(keyword);

        CommonUtils.sleep(1);
        //click on search button
        keyword_input_textbox.sendKeys(Keys.ENTER.toString());
    }


    public PaymentPage gotoPaymentScreen() {
        driver.findElement(By.className("cart")).click();
        driver.findElement(By.id("checkoutButtonTop")).click();
        paymentPage = new PaymentPage();
        paymentPage.login();
        return paymentPage;
    }

    public void navigate(String page) {

        String[] links = page.split("-");
        String mainLink = links[0].trim();
        String subLink = links[1].trim();

        driver.findElement(By.linkText(mainLink)).click();
        CommonUtils.sleep(3);
        driver.findElement(By.linkText(subLink)).click();
    }
}
