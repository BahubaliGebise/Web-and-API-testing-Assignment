package Util;

import Core.ReadTestCaseData_Implementation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class WebPageOperation extends ReadTestCaseData_Implementation {
    static  int maxNoOfRetries =5;

    public static void clickOperation(WebElement element){
        int counter= 0;
        while(maxNoOfRetries > 0 && counter != maxNoOfRetries ){
            try{
                element.click();
                break;

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }
    }



    public static void clickCheckBox(WebElement element){
        int counter= 0;
        while(maxNoOfRetries > 0 && counter != maxNoOfRetries ){
            try{
                if (!element.isSelected()){
                    element.click();
                }
                break;

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }
    }


    public static void populateField(WebElement element, String text){
        int counter= 0;
        while(maxNoOfRetries > 0 && counter != maxNoOfRetries ){
            try{
               element.clear();
               element.sendKeys(text);
               element.sendKeys(Keys.TAB);
                break;

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }
    }

    public static void selectDropDownElement(WebElement element, String text){
        int counter= 0;
        while(maxNoOfRetries > 0 && counter != maxNoOfRetries ){
            try{
                new Select(element).selectByVisibleText(text);
                break;

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }


        }
    }


    public static void selectDropDownElementCarMaking(){


            try{
                Thread.sleep(2000);
                WebElement lst = driver.findElement(By.xpath("//*[@id=\"ext-gen8\"]/div[1]"));
                Thread.sleep(1000);
                lst.click();


            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }



    }

    public static void selectDropDownElementCarModel(){


            try{
                Thread.sleep(5000);
                WebElement DropElement = driver.findElement(By.xpath("//*[@id=\"ext-gen12\"]/div[1]"));
                Thread.sleep(1000);
                DropElement.click();
                Thread.sleep(4000);
/*
                Thread.sleep(8000);
                WebElement RdioButton = driver.findElement(By.xpath("//*[@id='autoquote:finInfo:1']"));
                Thread.sleep(1000);
                RdioButton.click();*/

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            }



    }

    public static void clickDropDownElementCarModel(){

            try{
                Thread.sleep(10000);
                //WebElement drpDwn= driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/fieldset/div[3]/div[1]/div/div/img"));
                ///((JavascriptExecutor) driver).executeScript("arguments[0].click()",drpDwn);
               // System.out.println("clicked successfuly1 ");
                //drpDwn.click();
                System.out.println("reached before obj");
                WebElement DropElement = driver.findElement(By.xpath("//*[@id=\"ext-gen6\"]"));
                Thread.sleep(1000);
                System.out.println("reached after obj");
                DropElement.click();
                Thread.sleep(4000);
                System.out.println("clicked successful");

            }catch(Exception e){
                driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT_TIME")), TimeUnit.SECONDS);
            fail();
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

    public static String getObjText(WebElement element){
        return element.getText();
    }

}
