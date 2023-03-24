package TestSteps;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
    public Locators() {

        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id="Email")
    public WebElement emailBox;

    @FindBy(id="Password")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;
    @FindBy(linkText = "Logout")
    public WebElement logoutBtn;


}
