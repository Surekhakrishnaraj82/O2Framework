package com.o2.test;

import cucumber.api.java.Before;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest extends Helper {
    Helper helper=new Helper();
   private static WebDriver driver;
   private static WebElement element, element1;

    @Before
    public void openBrowser() {
        driver=new FirefoxDriver();
        driver.get("https://www.O2.co.uk");
        driver.manage().window().maximize();
    }
    @Test
    public void phones(String samsung) {
        //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        Actions action=new Actions(driver);
        WebElement element1= driver.findElement(By.xpath("//li[@name='Shop']//a[contains(text(),'Shop')]"));
        action.moveToElement(element1).perform();
        WebElement element= driver.findElement(By.xpath("//li[contains(@class,'tier-menu-wrapper')]//ul//li//a[contains(text(),'Phones')]"));
        action.moveToElement(element).click().perform();
       /* Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/nav[1]/div[3]/header[1]/nav[1]/div[1]/div[1]/ul[2]/li[1]/a[1]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/nav[1]/div[3]/header[1]/nav[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]"))).click().build().perform();*/
    }
    @Test
    public void paymentOption()
    {   driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        //element= driver.findElement(By.linkText("Pay Monthly"));
         driver.findElement(By.linkText("Pay As You Go")).click();
    }
    @Test
    public void filterOption()
    {
        // Brand
        driver.findElement(By.cssSelector(".accordion-title.enhanced-filter-link")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".section.brand"))).click();
        List<WebElement> elements= new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sort-list-tabulated")));

        //RANDOMLY SELECTING PHONE MODELS
        /*int randomNumber=helper.randomNumberGeneration(elements.size());
        int randomNumber2=helper.randomNumberGeneration(elements.size());
        System.out.println(randomNumber);
        elements.get(randomNumber).click();
        System.out.println(randomNumber2);
        elements.get(randomNumber2).click();
        action.moveToElement(elements.get(randomNumber)).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);*/

        driver.findElement(By.cssSelector("#brand11")).click();
        driver.findElement(By.cssSelector(".secondary.done-btn.filter-done")).click();
        List<WebElement> collectedPhoneElements=driver.findElements(By.cssSelector("p[data-qa-canonical-brand='samsung']"));
        List<String>  collectedPhoneNames=new ArrayList<>();
        for (WebElement collectedPhoneElement:collectedPhoneElements) {
            String phoneName=collectedPhoneElement.getText();

            collectedPhoneNames.add(phoneName);
        }
        assertThat("Starts with Samsung", "Samsung", Matchers.startsWith("Samsung"));
          //  driver.findElement(By.cssSelector("#brand2")).click();
        //driver.findElement(By.cssSelector("#brand3")).click();

       // Colour
 /*   driver.findElement(By.cssSelector(".section.colour")).click();
    driver.findElement(By.cssSelector("#colour7")).click();
    driver.findElement(By.cssSelector("#colour2")).click();
    driver.findElement(By.cssSelector("#colour5")).click();*/
   // driver.findElement(By.cssSelector(".secondary.done-btn.filter-done")).click();
    }
    public void sortOption()
    {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
      driver.findElement(By.cssSelector(".accordion-title.enhanced-sorts-link")).click();
        List<WebElement> elementslist= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".check")));
//List<WebElement> elementslist= driver.findElements(By.cssSelector(".filter-sort-list"));
        System.out.println(elementslist);
        int randomNumber3=helper.randomNumberGeneration(elementslist.size());
        System.out.println(randomNumber3);
        elementslist.get(randomNumber3).click();
   // driver.findElement(By.linkText("Camera resolution")).click();
    /*driver.findElement(By.cssSelector("#brand2")).click();
    driver.findElement(By.cssSelector("#brand3")).click();

       // Colour
    driver.findElement(By.cssSelector(".section.colour")).click();
    driver.findElement(By.cssSelector("#colour7")).click();
    driver.findElement(By.cssSelector("#colour2")).click();
    driver.findElement(By.cssSelector("#colour5")).click();
    driver.findElement(By.cssSelector(".secondary.done-btn.filter-done")).click();*/
        driver.findElement(By.cssSelector(".secondary.done-btn.sorts-done")).click();
    }
}
