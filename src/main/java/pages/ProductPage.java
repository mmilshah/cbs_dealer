package pages;

import Utils.Utils;
import org.openqa.selenium.By;

/**
 * Created by sriramangajala on 11/12/15.
 */
public class ProductPage extends BasePage {
    public void selectDefaultOptionsAndAddItemToBasket() {
        Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
        driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
        Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[3]"));
        driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[3]")).click();
        Utils.sleep(3);
        if(Utils.isElementPresent(By.id("addToCartButton")))
            driver.findElement(By.id("addToCartButton")).click();
        else
        {
            Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
            driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
            Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[2]"));
            driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[2]")).click();
            if(Utils.isElementPresent(By.id("addToCartButton")))
            {
                Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/span"));
                driver.findElement(By.xpath("//div[@id='variantDropDown']/div/span")).click();
                Utils.waitElementPresent(By.xpath("//div[@id='variantDropDown']/div/div/span[4]"));
                driver.findElement(By.xpath("//div[@id='variantDropDown']/div/div/span[4]")).click();
            }
            driver.findElement(By.id("addToCartButton")).click();
        }
        Utils.waitForTextOnElement(By.className("shoppingCartCount"),"1");
    }
}
