package com.gap.component;


import com.google.common.base.Function;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class BaseTestHelper {

    //The 'browser' itself
    public WebDriver driver;

    //Util Variables
    public String gap_url = "http://rocky-escarpment-5701.herokuapp.com/users/sign_in";

    @BeforeTest
    public void setupSelenium(){
        //Start the browser (firefox for now)
        driver = new FirefoxDriver();

        //This adds implicit timeouts to the driver (instead of clickAndWait())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeSelenium(){
        //Shutdown the browser
        driver.quit();
    }

    public void refreshSelenium(){
        closeSelenium();
        setupSelenium();
    }

// ***** Login *****

    //Login to GAP
    public void access_Gap(){
        navigateToAbsoluteUrl(gap_url);
    }

// ***** Navigate to URL *****

    protected void navigateToAbsoluteUrl(String url) {
        driver.navigate().to(url);
    }

// ***** Is Element Displayed *****

    //Return True or False if element found or not
    protected boolean checkIfElementFound(String cssSelector) {
        return elementPresent(cssSelector).apply(driver);
    }

    protected Function<WebDriver, Boolean> elementPresent(final String cssSelector) {
        return new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return findElements(cssSelector).size() > 0;
            }
        };
    }

    protected List<WebElement> findElements(String selector) {
        List<WebElement> result = driver.findElements(By.cssSelector(selector));
        return result;
    }

// ***** Clicks *****

    //Click over existent element
    protected void click(String selector) {
        findElement(selector).click();
    }

    protected WebElement findElement(String selector) {
        try{
            return driver.findElement(By.cssSelector(selector));
        }
        catch(Exception e){
            //Just capture the exception to add more verbosity to it
            String msg = "Couldn't find css selector [" + selector + "] on page: [" + driver.getCurrentUrl() + "]";
            throw new NoSuchElementException(msg);
        }
    }

// ***** Search *****

    //Search
    protected void sendKeys(String selector, String text) {
        this.clear(selector);
        findElement(selector).sendKeys(text);
    }

    protected void clear(String selector) {
        findElement(selector).clear();
    }

// ***** GetText *****

    protected String getText(String selector) {
        return findElement(selector).getText().toUpperCase().trim();
    }

// ***** Pause *****

    public void pause(Integer seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

// ***** Random Email *****

    public static String randomizeEmail(String email) {
        String part1 = email.substring(0, email.indexOf("@"));
        String randomEmail = part1 + RandomStringUtils.randomAlphanumeric(6) + email.substring(email.indexOf("@"), email.length());
        return randomEmail.toLowerCase();
    }

    public static String randomizeData(String dato) {
        int numeroAleatorio = (int) (Math.random()*25+1);
        String randomData = dato + numeroAleatorio;
        return randomData.toLowerCase();
    }

    public String selectRandomOptionInSelect(String selector) {
        //if (checkIfElementFound(selector)) {
        Select dropDown = new Select(findElement(selector));

        int dropDownSize = dropDown.getOptions().size();


        int optionToSelect = 0;
        if (dropDownSize > 1) {
            optionToSelect = randomInt(dropDownSize);
            if (optionToSelect == 0) {
                optionToSelect = randomInt(dropDownSize);
            }
        }

        String result = dropDown.getOptions().get(optionToSelect).getText().trim();

        dropDown.selectByIndex(optionToSelect);

        return result;

    }

    protected int randomInt(int max) {
        int result = RandomUtils.nextInt(max) + 1;// - 1
        if (result == max) {
            result--;
        }
        return result;
    }

// ***** Dates *****

    protected String dateToday() {

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String reportDate = df.format(today);

        return reportDate;


    }

    protected String dateSince(){

        Date date = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // Add random 20 days from the calendar
        cal.add(Calendar.DATE, randomInt(20));

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Get the date today using Calendar object.
        Date today = cal.getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String reportDate = df.format(today);

        return reportDate;

    }

    protected String dateUntil(){

        Date date = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // Add random 20 days from the calendar
        cal.add(Calendar.DATE, randomInt(60));

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        // Get the date today using Calendar object.
        Date today = cal.getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String reportDate = df.format(today);

        return reportDate;

    }

}
