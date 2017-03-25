package pages;

import utils.CommonUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sriramangajala on 18/09/16.
 */
public class HomePage extends BasePage{


    @FindBy(how = How.ID, using = "search-address-inputEl")
    public WebElement search_address;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void checkUserIsInHomePage() {

        Assert.assertTrue(driver.getCurrentUrl().equals("https://uat.mapflow.com/geo12/home.htm"));
    }

    public void searchForText(String text) {
        search_address.sendKeys(text);
        CommonUtils.waitElementPresent(By.xpath("//span[text(),'"+text+"']"));
        driver.findElement(By.xpath("//span[text(),'"+text+"']")).click();
    }
}
