package com.test.mavenproject;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;

public class NewTest {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver","C:\\Automation_folder\\All_Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }

    @Test
    public void OfferSummaryPage() throws IOException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        // Store url in variable and go to url
        String OfferSummaryPageURL = "https://www.loveholidays.com/book/flight-and-hotel/offer-summary.html?shortref=LA9YVPJH&state=AwoUKFAAIKSCaCeCjLYYEIABgHA";
        driver.get(OfferSummaryPageURL);
        
        //Get page title
        String pageName = driver.getTitle();
        System.out.println("You are now on the " + pageName +" page");
        
        // Defining the home button as an element
        WebElement HomeBtn =  driver.findElement(By.className("book-header-nav-bar__list__item__link"));
        
        // Define close button as element and click on close button
        WebElement CloseBtn = driver.findElement(By.cssSelector("a.notifications-layout__close"));       
        CloseBtn.click();
        
        //Wait until home button is clickable and then click on it
        WebDriverWait wait = new WebDriverWait(driver, 15);
        
        //wait for element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(HomeBtn));
        HomeBtn.click();
        
        Thread.sleep(5000);
        //Verify the user can see the box "Still interested in a holiday to Zante?" on the homepage
        WebElement offerTitle = driver.findElement(By.xpath("//*[@id='page-content']/DIV[3]/DIV[1]/DIV[1]/DIV[1]/DIV[1]"));
        wait.until(ExpectedConditions.visibilityOf(offerTitle));
     
        //Click on "Check latest price"
        WebElement CheckLatestPriceBtn = driver.findElement(By.partialLinkText("Check latest price"));
        CheckLatestPriceBtn.click();
        
        // Verify you are taken to the offer summary page
        String OfferSummaryPage = driver.getTitle();
        System.out.println("You are now on the " + OfferSummaryPage +" page");  
       
    }
}