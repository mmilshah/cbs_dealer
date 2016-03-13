package pages;

import Utils.AutomationConstants;
import Utils.CommonUtils;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.ExplicitGroup;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sriramangajala on 11/12/15.
 */
public class ProductPage extends BasePage {
    public void selectDefaultOptionsAndAddItemToBasket() {
        CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
        driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
        CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[3]"));
        driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[3]")).click();
        CommonUtils.sleep(3);
        if (CommonUtils.isElementPresent(By.id("addToCartButton")))
            driver.findElement(By.id("addToCartButton")).click();
        else {
            CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
            driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
            CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[2]"));
            driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[2]")).click();
            if (CommonUtils.isElementPresent(By.id("addToCartButton"))) {
                CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
                driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
                CommonUtils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[4]"));
                driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[4]")).click();
            }
            driver.findElement(By.id("addToCartButton")).click();
        }
        CommonUtils.waitForTextOnElement(By.className("shoppingCartCount"), "1");
    }

    public void checkNumberOfProducts(int count) {
        CommonUtils.sleep(3);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, AutomationConstants.MAX_TIMEOUTS);
//
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//table[@id='ProductDetailsGrid']/tbody/tr[2]]"))));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ProductDetailsGrid']/tbody/tr"));
        int numberOfRows = (rows.size() - 1);
        System.out.println("Total count of rows " + numberOfRows);

        Assert.assertTrue(numberOfRows >= count);

    }
}
