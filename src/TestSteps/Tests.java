package TestSteps;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests extends BaseDriver {
    public String email = "admin@yourstore.com";
    public String password = "admin";

    @Test(priority = 1)
    void LoginTest() {
        Locators lc = new Locators();
        lc.loginBtn.click();

    }

    @Test(priority = 2)
        void leftnavCheckTest() {
            LeftnavLocators ln = new LeftnavLocators();
            for (WebElement e : ln.leftnav) {
                e.click();
            }
        }

    }


