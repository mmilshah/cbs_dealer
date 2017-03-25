package pages;

import utils.CommonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sriramangajala on 18/09/16.
 */
public class MapLogin extends BasePage {


    //////////////elements/////
    @FindBy(how = How.ID, using = "username")
    public WebElement txt_username;

    @FindBy(how = How.ID, using = "password-temp")
    public WebElement txt_password_temp;


    @FindBy(how = How.ID, using = "password")
    public WebElement txt_password;


    @FindBy(how = How.XPATH, using = "//div[@class='password-submit']/input[@class='button']")
    public WebElement btn_submit;

    public MapLogin() {

        PageFactory.initElements(driver, this);
    }


    //////////////elements/////


    public HomePage loginToApplication(String username, String password) {

        txt_username.sendKeys(username);
        CommonUtils.sleep(2);
        txt_password_temp.click();
        CommonUtils.sleep(2);
        txt_password.sendKeys(password);
        btn_submit.click();


        return new HomePage();
    }
}
