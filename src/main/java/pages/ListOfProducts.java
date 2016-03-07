package pages;

import org.openqa.selenium.By;

/**
 * Created by sriramangajala on 11/12/15.
 */
public class ListOfProducts extends BasePage {
    public ProductPage openProduct(String product) {
        driver.findElement(By.xpath("//a[@class='productMainLink']//div[text()='"+product+"']")).click();
        return new ProductPage();
    }
}
