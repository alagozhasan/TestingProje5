package TestSteps;

import Utility.BaseDriver;
import Utility.Tools;
import com.beust.ah.A;
import javafx.scene.web.WebEngine;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Tests extends BaseDriver {

    public String email ;
    public String firstname = "Grup";
    public String lastname = "On bir";
    public String password = "grup11ts";


    @Test(priority = 1)
    void LoginTest() {
        Locators lc = new Locators();
        lc.loginBtn.click();

    }

    @Test(priority = 2)
    void leftnavCheckTest() {
        LeftnavLocators ln = new LeftnavLocators();
        for (int i = 0; i < ln.leftnav.size(); i++) {
            ln.leftnav.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(ln.leftnavIn.get(ln.leftnavIn.size() - 1)));
            System.out.println(ln.leftnav.get(i).getText() + "Son parçası : " + ln.leftnavIn.get(ln.leftnavIn.size() - 1).getText());

            Assert.assertTrue(ln.leftnavIn.get(
                    ln.leftnavIn.size() - 1
            ).isDisplayed());
        }
    }

    @Test(priority = 3, dependsOnMethods = {"LoginTest"})
    void CreateCustomerTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        LeftnavLocators ln = new LeftnavLocators();
        FormLocators f = new FormLocators();
        ln.leftnav.get(2).click();
        ln.leftnavIn.get(0).click();
        ln.addNewBtn.click();
//Form Doldur-yeni
        email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
        f.EmailBox.sendKeys(email);
        f.SecondBox.sendKeys("grup11");
        f.ThirdBox.sendKeys(firstname);
        f.FourthBox.sendKeys(lastname);
        f.clickFunction(f.MaleGender);
        f.BirthDayBox.sendKeys("7/18/2002");
        f.CompanyBox.sendKeys("Grup11");
        f.clickFunction(f.taxPick);
        f.clickFunction(f.NewsLetterBox);
        f.optionsAriaHidden.get(1).click();
        f.TextArea.sendKeys("Comment comment commment comment");
        f.saveCustomerBtn.click();
        System.out.println("f.succesAlert.getText() = " + f.succesAlert.getText());
        Assert.assertTrue(f.succesAlert.isDisplayed());
    }

    @Test(priority = 4, dependsOnMethods = {"CreateCustomerTest"})
    void EditCustomerTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        FormLocators f = new FormLocators();

        f.EmailBox.sendKeys(email);
        f.SecondBox.sendKeys(firstname);
        f.ThirdBox.sendKeys(lastname);
        f.searchBtn.click();
        f.searchBtn.click();

        WebElement editbtn = driver.findElement(By.xpath("((//tr[@class='odd'])[1]/td)[7]"));
        editbtn.click();

        f.EmailBox.click();
        email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";

        f.EmailBox.clear();
        f.EmailBox.sendKeys("hasanftCezaftSago@hotmail.com");
        f.saveCustomerBtn.click();
        System.out.println(f.succesAlert.getText());
        Assert.assertTrue(f.succesAlert.isDisplayed());
    }
}


