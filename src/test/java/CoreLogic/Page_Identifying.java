package CoreLogic;
import Util.WebPageOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class Page_Identifying {

    @FindBy(xpath= "//*[@id=\"P389-C2-C0-C0-F2-0\"]")
    WebElement FormOfIndentification;

    @FindBy(xpath= "//*[@id=\"P389-C2-C0-C1-C1-C1-F0\"]")
    WebElement Email_contact;

    @FindBy(xpath= "//*[@id=\"P389-C2-C0-C1-C1-C2-F0\"]")
    WebElement Telephone_contact;

    @FindBy(xpath= "//*[@id=\"P389-C2-C1-B1\"]/span")
    WebElement ToClosingQuestionNextButton;

    @FindBy(xpath= "//*[@id=\"field-P389-C2-C0-C1-C1-C1-F0\"]/div/div/ofm-field-validation/div/span/span[2]")
    WebElement WrongEmailID_ErrMsg;

    @FindBy(xpath= "//*[@id=\"field-P389-C2-C0-C1-C1-C2-F0\"]/div/div/ofm-field-validation/div/div/span/span[2]")
    WebElement WrongPhoneNum_ErrMsg;



    public Page_Identifying(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




    public void click_FormOfIndentification(){

        WebPageOperation.waitForObject(Email_contact);
        WebPageOperation.clickOperationRadioButton(FormOfIndentification);

    }

    public void entire_Email_contact(String email_ID){


        WebPageOperation.populateField(Email_contact,email_ID);

    }


    public void entire_Telephone_contact(String TelephoneContact){


        WebPageOperation.populateField(Telephone_contact,TelephoneContact);

    }

    public void click_ToClosingQuestionNextButton(){

        WebPageOperation.clickOperation(ToClosingQuestionNextButton);

    }

    public void get_Email_ErrorMsg(String ErrText){

       String ErrEmailTxt = WebPageOperation.getText(WrongEmailID_ErrMsg);
        System.out.println("Email error text from UI   : " +ErrEmailTxt);

        assertEquals(ErrEmailTxt, ErrText);

    }

    public void get_Telephone_ErrorMsg(String ErrTextTele){

        String ErrTelephoneTxt = WebPageOperation.getText(WrongPhoneNum_ErrMsg);
        System.out.println("Telephone error text from UI   : " +ErrTelephoneTxt);

        assertEquals(ErrTelephoneTxt, ErrTextTele);

    }


}
