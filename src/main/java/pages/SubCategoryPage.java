/****************************************************************************
 Author: Laddu shashavali
 Last updated: 01/20/19
 Description: Page object to handle locators and methods for Sub Category page
 ***************************************************************************/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Utils.expectedConditions;

public class SubCategoryPage {

    private WebDriver driver;

    public SubCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //label for subcategory header
    @FindBy(how = How.XPATH, using = "//div[5]/section/h1")
    private WebElement lblHeader;

    //laberl for filter section
    @FindBy(how = How.XPATH, using = "//div[1]/header/h2")
    private WebElement lblFilter;

    //textbox to search in filter
    @FindBy(how = How.ID, using = "location")
    private WebElement txtSearch;

    //div containing a subcategory product
    @FindBy(how = How.XPATH, using = "//section[@id='ac-cloudSearchResults']//article[1]//a[1]")
    private WebElement divSubCategoryBox;


    public String CheckSubCategoryPage() throws InterruptedException {
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.visibilityOf(lblHeader));
        return lblHeader.getText();
    }

    public String CheckFilter() throws InterruptedException {
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.visibilityOf(lblFilter));
        return lblFilter.getText();
    }

    public void setTxtSearch(String title) {
        WebElement search = driver.findElement(By.id("location"));
        txtSearch.sendKeys(title);
        txtSearch.sendKeys(Keys.RETURN);
    }

    public void ClickonBox() {
        expectedConditions(driver,divSubCategoryBox);
        divSubCategoryBox.click();
    }


}
