package TestSteps;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftnavLocators {
    public LeftnavLocators() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "nav[class='mt-2']>ul>li[class='nav-item has-treeview']>a")
    List<WebElement> leftnav;

    @FindBy(css = "ul[class='nav nav-treeview'][style='display: block;']>li")
    List<WebElement> leftnavIn;

    @FindBy(linkText = "Add new")
    WebElement addNewBtn;
}

