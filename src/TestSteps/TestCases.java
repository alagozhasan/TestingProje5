package TestSteps;

import Utility.BaseDriver;
import Utility.Tools;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCases {

    public String email;
    public String firstname = "Grup";
    public String lastname = "On bir";
    public String password = "grup11ts";

    private WebDriver driver;
    private WebDriverWait wait;

    @Test(priority = 1)
    void LoginTest() {
        driver.get("https://admin-demo.nopcommerce.com/login?");

        Locators lc = new Locators(driver);
        lc.loginBtn.click();

    }

    @Test(priority = 2)
    void leftnavCheckTest() {
        LeftnavLocators ln = new LeftnavLocators(driver);
        Locators l = new Locators(driver);
        FormLocators f = new FormLocators(driver);
        for (int i = 0; i < ln.leftnav.size(); i++) {
            ln.leftnav.get(i).click();
//            wait.until(ExpectedConditions.visibilityOf(ln.leftnavIn.get(ln.leftnavIn.size() - 1)));
            wait.until(ExpectedConditions.elementToBeClickable(ln.leftnav.get(i+1)));
            Tools.Bekle(2);
            System.out.println(ln.leftnav.get(i).getText() + "Son parçası : " + ln.leftnavIn.get(ln.leftnavIn.size() - 1).getText());

            Assert.assertTrue(ln.leftnavIn.get(
                    ln.leftnavIn.size() - 1
            ).isDisplayed());
        }
    }

    @Test(priority = 3, dependsOnMethods = {"LoginTest"})
    void CreateCustomerTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        LeftnavLocators ln = new LeftnavLocators(driver);
        FormLocators f = new FormLocators(driver);
        ln.leftnav.get(2).click();
        ln.leftnavIn.get(0).click();
        ln.addNewBtn.click();
//Form Doldur-yeni
        email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
        f.EmailBox.sendKeys(email);
        f.SecondBox.sendKeys("grup11");
        f.ThirdBox.sendKeys(firstname);
        f.FourthBox.sendKeys(lastname);
        f.clickFunction(f.MaleGender, driver);
        f.BirthDayBox.sendKeys("7/18/2002");
        f.CompanyBox.sendKeys("Grup11");
        f.clickFunction(f.taxPick, driver);
        f.clickFunction(f.NewsLetterBox, driver);
        f.optionsAriaHidden.get(1).click();
        f.TextArea.sendKeys("Comment comment commment comment");
        f.saveCustomerBtn.click();
        System.out.println("f.succesAlert.getText() = " + f.succesAlert.getText());
        Assert.assertTrue(f.succesAlert.isDisplayed());
    }

    @Test(priority = 4, dependsOnMethods = {"CreateCustomerTest"})
    void EditCustomerTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        FormLocators f = new FormLocators(driver);

        f.EmailBox.sendKeys(email);
        f.SecondBox.sendKeys(firstname);
        f.ThirdBox.sendKeys(lastname);
        f.searchBtn.click();
        f.searchBtn.click();

        f.editBtn.click();

        f.EmailBox.click();
        email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";

        f.EmailBox.clear();
        f.EmailBox.sendKeys("hasanftCezaftSago@hotmail.com");
        f.saveCustomerBtn.click();
        System.out.println(f.succesAlert.getText());
        Assert.assertTrue(f.succesAlert.isDisplayed());
    }

    @Test(priority = 5, dependsOnMethods = {"CreateCustomerTest"})
    void deleteCustomer(String email) {
        Locators l = new Locators(driver);
        LeftnavLocators ln = new LeftnavLocators(driver);
        FormLocators f = new FormLocators(driver);
        ln.leftnav.get(2).click();
        ln.leftnavIn.get(0).click();
        ln.addNewBtn.click();

        f.EmailBox.sendKeys(email);
        f.SecondBox.sendKeys(firstname);
        f.ThirdBox.sendKeys(lastname);
        f.searchBtn.click();

        f.editBtn.click();
        f.deleteButton.click();
        f.deleteAlert.click();

        Tools.successMessageValidation(driver);
    }

    @Test(priority = 6, dependsOnMethods = {"LoginTest"})
    void searchTest() {
        FormLocators f = new FormLocators(driver);


        f.leftNavSearchBox.sendKeys("Shipments");
        f.leftNavSearchClick.click();

        Tools.assertIsDisplayed(f.shipments);

    }
        @BeforeClass
    @Parameters("browserTipi")
    public void setUp(String browserName) {
        BaseDriver bd = new BaseDriver();
        driver = bd.getDriver(browserName);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            Tools.Bekle(3);
            driver.quit();
        }
    }
}


