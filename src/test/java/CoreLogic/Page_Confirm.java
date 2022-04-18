package CoreLogic;
import Util.WebPageOperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Page_Confirm {

    @FindBy(xpath= "//*[@id=\"P580-C2-C0-TI5\"]/span/p/table/tbody/tr[9]/td")
    WebElement Confirm_DOB;

    @FindBy(xpath= "//*[@id=\"P580-C2-C0-TI5\"]/span/p/table/tbody/tr[12]/td")
    WebElement Confirm_Telephone;

    @FindBy(xpath= "//*[@id=\"P580-C2-C0-TI5\"]/span/p/table/tbody/tr[15]/td")
    WebElement Confirm_EmailID;

    @FindBy(xpath= "//*[@id=\"P580-C2-C1-B1\"]")
    WebElement ClickApplyButton;


    @FindBy(xpath= "//*[@id=\"P872-C1-C0-TI2\"]/p/h3[1]")
    WebElement AccountSuccessText;

    public Page_Confirm(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




    public void get_ConfirmPage_DOB(String DOB_confirm){

        //WebPageOperation.waitForObject(Confirm_DOB);
        String textDOB_UI = WebPageOperation.getObjText(Confirm_DOB);

        System.out.println("Date of birth from UI screen : "+textDOB_UI);
        assertEquals(textDOB_UI, DOB_confirm);
    }

    public void get_ConfirmPage_Telephone(String TelephoneNum){

       // WebPageOperation.waitForObject(Confirm_Telephone);
        String textTeleNum_UI =WebPageOperation.getObjText(Confirm_Telephone);

        System.out.println("Telephone number from UI screen : "+textTeleNum_UI);
        assertEquals(textTeleNum_UI, TelephoneNum);
    }


    public void getConfirmPage_EmailID(String EmailID){

       // WebPageOperation.waitForObject(Confirm_EmailID);
        String textEmail_UI = WebPageOperation.getObjText(Confirm_EmailID);
        System.out.println("EMail ID from UI screen : "+textEmail_UI.trim());
        assertEquals(textEmail_UI.trim(), EmailID);

    }

    public void ClickApplyButton(){
       // WebPageOperation.waitForObject(ClickApplyButton);
        WebPageOperation.clickOperation(ClickApplyButton);
      //  WebPageOperation.waitForObject(AccountSuccessText);
    }


    public void getAccountCreatedSuccessText(String successMsg){

        System.out.println("Verify account created success message");
        String textObjMsg= WebPageOperation.getObjText(AccountSuccessText);

        System.out.println("Message from UI screen : "+textObjMsg);
        assertEquals(textObjMsg.trim(), successMsg);

    }


}
