package Util;

import CoreLogic.ReadTestCaseData_Implementation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;



public class WebPageOperation extends ReadTestCaseData_Implementation {


    public static void clickOperation(WebElement element){

            try{
                waitForObject(element);

                element.click();


            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }

    }

    public static void clickOperationRadioButton(WebElement element){


            try{

                element.click();


            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }

    }

    public static String getText(WebElement element){

        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return element.getText();
    }

    public static void clickCheckBox(WebElement element){

            try{
                if (!element.isSelected()){
                    element.click();
                }


            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }



    public static void populateField(WebElement element, String text){

            try{
               waitForObject(element);
               element.clear();
               element.sendKeys(text);
               element.sendKeys(Keys.TAB);


            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }



    public static boolean isElementPresent(WebElement element){
        boolean available= false;
        try{
            if(element.isDisplayed())
                available=true;

            return available;


        }catch(NoSuchElementException e){
         return available;
        }
    }


    public static void waitForObject(WebElement element2){

            try {
                //new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element2));
               // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeSelected(element2));
                driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                Thread.sleep(3000);
                new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element2));

            } catch(StaleElementReferenceException | InterruptedException e) {
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);

            }

    }


    public static String getObjText(WebElement element){
        waitForObject(element);
        return element.getText();
    }


}
