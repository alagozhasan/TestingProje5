package TestSteps;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.lang.invoke.CallSite;
import java.util.List;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class FormLocators {
    public FormLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement EmailBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[2]")
    WebElement SecondBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[3]")
    WebElement ThirdBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[4]")
    WebElement FourthBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[5]")
    WebElement MaleGender;


    @FindBy(xpath = "(//div[@class='card-body']//input)[6]")
    WebElement FemaleGender;

    @FindBy(xpath = "(//div[@class='card-body']//input)[7]")
    WebElement BirthDayBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[8]")
    WebElement CompanyBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[9]")
    WebElement taxPick;

    @FindBy(xpath = "(//div[@class='card-body']//input)[10]")
    WebElement NewsLetterBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[11]")
    WebElement CustomRolesBox;

    @FindBy(xpath = "(//div[@class='card-body']//input)[12]")
    WebElement ActiveCheckBox;

    @FindBy(xpath = "//div[@class='card-body']//textarea")
    WebElement TextArea;


    @FindBy(xpath = "//ul[@aria-hidden='false']/li")
    List<WebElement> optionsAriaHidden;

    @FindBy(name = "save")
    WebElement saveCustomerBtn;

    @FindBy(css = "[id='search-customers']")
    WebElement searchBtn;

    @FindBy(css = "[class='alert alert-success alert-dismissable']")
    WebElement succesAlert;

    @FindBy(css = "tbody td:nth-child(2)")
    WebElement resultEmail;

    @FindBy(css = "((//tr[@class='odd'])[1]/td)[7]")
    WebElement EditBtn;




    public void clickFunction(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", e);
        e.click();
    }

}
