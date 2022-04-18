package CoreLogic;

import Util.WebPageOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_ClosingQuestions {


    @FindBy(xpath= "//*[@id=\"P388-C2-C0-C0-C2-F1-2\"]")
    WebElement Income_NotApplicable;

    @FindBy(xpath= "//*[@id=\"P388-C2-C0-C0-C2-F4-1\"]/span")
    WebElement Not_OwnerOfCompany;

    @FindBy(xpath= "//*[@id=\"P388-C2-C0-C0-C2-F6-1\"]")
    WebElement TransferLessThan_500k;

    @FindBy(xpath= "//*[@id=\"P388-C2-C0-C0-C2-F7-1\"]")
    WebElement NotRefused;

    @FindBy(xpath= "//*[@id=\"P388-C2-C1-B1\"]")
    WebElement OverviewNextButton;



    public Page_ClosingQuestions(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




    public void click_Income_NotApplicable(){
        WebPageOperation.waitForObject(Not_OwnerOfCompany);
        WebPageOperation.clickOperationRadioButton(Income_NotApplicable);

    }

    public void click_Not_OwnerOfCompany(){

        WebPageOperation.clickOperation(Not_OwnerOfCompany);

    }


    public void click_TransferLessThan_500k(){

        WebPageOperation.clickOperation(TransferLessThan_500k);

    }

    public void click_NotRefused(){

        WebPageOperation.clickOperation(NotRefused);

    }

    public void click_OverviewNextButton(){


        WebPageOperation.clickOperation(OverviewNextButton);

    }

}
