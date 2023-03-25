package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void Bekle(int sn)
    {
        try {
            Thread.sleep(1000*sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void successMessageValidation(WebDriver driver){
        WebElement subscription = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissable']"));
        Assert.assertTrue(subscription.getText().toLowerCase().contains("success"));
    }


    public static int RandomGenerator(int max){ //4
        return (int)(Math.random()*max); // 0,1,2,3
    }

    public static void assertIsDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed(),"Element is not displayed");
    }

}
