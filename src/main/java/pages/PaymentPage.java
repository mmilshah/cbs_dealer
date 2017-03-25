package pages;

import utils.AutomationConstants;
import utils.CommonUtils;
import utils.VerifyUtils;
import org.openqa.selenium.By;

/**
 * Created by sriramangajala on 11/12/15.
 */
public class PaymentPage extends BasePage{
    public void login() {
        driver.findElement(By.id("j_username")).sendKeys(AutomationConstants.USERNAME);
        driver.findElement(By.id("j_password")).sendKeys(AutomationConstants.PASSWORD);
        driver.findElement(By.cssSelector("button.button.login-btn.btn-form")).click();
        CommonUtils.waitForText("REVIEW AND PAY");
    }

    public void paywithDefaultCard() {
        CommonUtils.clickIfPresent(By.className("newcard-form-label-text"));
        selectPaymentCard("Visa");
        driver.findElement(By.name("cardNumber")).sendKeys("4111111111111111");
        driver.findElement(By.name("cardName")).sendKeys("Test User");
        driver.findElement(By.name("expireMonth")).click();
        selectSpan("01");
        driver.findElement(By.name("expireYear")).click();
        selectSpan("2016");
        driver.findElement(By.name("securityCode")).sendKeys("123");
        driver.findElement(By.cssSelector("button.purchaseNowBtn.button.btn-form.purchase-btn")).click();
    }

    private void selectPaymentCard(String card) {
//        CommonUtils.waitElementPresent(By.xpath("//span[text()='Select card type*']"));
//        driver.findElement(By.xpath("//span[text()='Select card type*']")).click();
//        CommonUtils.sleep(3);
//        CommonUtils.waitElementPresent(By.className("visa-card"));
//        CommonUtils.sleep(3);
        if(card.equalsIgnoreCase("visa"))
            driver.findElement(By.className("visa-card")).click();

    }
    private void selectSpan(String text) {
       // CommonUtils.waitElementPresent(By.xpath("//span[text()='" + text+" ']"));
        driver.findElement(By.xpath("//span[text()='" + text+"']")).click();
//        CommonUtils.sleep(3);
//        CommonUtils.waitElementPresent(By.className("visa-card"));
//        CommonUtils.sleep(3);

    }

    public void checkNoErrorMessagesShown() {
        CommonUtils.sleep(3);
        CommonUtils.waitWhileElementPresent(By.className("busy-overlay__icon"));
        VerifyUtils.True("Check if error message shown", !(CommonUtils.isElementPresent(By.xpath("//*[@class='error']"))|| CommonUtils.isElementPresent(By.xpath("//*[@class='payment__error-message']"))));
    }
}
