/****************************************************************************
 Author: Laddu shashavali
 Last updated: 01/18/19
 Description: Class to handle util functions across the solution
 ***************************************************************************/

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static boolean existsElement (WebDriver driver, By locator){
            try {
                driver.findElement(locator);
            } catch (Exception e) {
               return false;
            }
        return true;
    }

    public static boolean existsElement (WebDriver driver,WebElement webElement){
        try {
            webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static WebElement expectedConditions(WebDriver driver,WebElement webElement) {
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (webElement.isDisplayed());
            }
        };
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(e);
        return existsElement(driver,webElement)?webElement:null;

    }

}
