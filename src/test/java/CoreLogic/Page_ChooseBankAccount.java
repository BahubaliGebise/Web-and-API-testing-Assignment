package CoreLogic;

import Util.WebPageOperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Util.TestBaseClass.testdata;
import static org.junit.Assert.assertEquals;

public class Page_ChooseBankAccount {


    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C1-F1-0\"]")
    WebElement BankProduct_Private;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C1-F1-1\"]")
    WebElement BankProduct_Business;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C1-TI2\"]/span/ofm-notification-block/div/p")
    WebElement BusinessAcc_LinkText;



    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C1-F3-0\"]")
    WebElement BankAccountFor_Myself;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C2-C0-C1-F0-0\"]")
    WebElement LiveIn_NL;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C2-C0-C3-C0-C0-F0\"]")
    WebElement Postal_Code;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C2-C0-C3-C0-C1-F0\"]")
    WebElement HouseNumber;

    @FindBy(xpath= "//*[@id=\"P391-C2-C1-C0-C0-C2-C0-C3-TI2\"]/span/ofm-notification-block/div/p")
    WebElement Wrong_HouseNumberError;

    @FindBy(xpath= "//*[@id=\"P391-C2-C2-B0\"]/span")
    WebElement TellUsWhoUr_Button;




    public Page_ChooseBankAccount(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




    public void click_BankingProducts_PrivatePurpose(){

     //Are you going to use the banking products for private or business purposes?

        WebPageOperation.clickOperation(BankProduct_Private);
    }

    public void click_BankAccountFor_Myself(){

        //Who is the bank account for?

        WebPageOperation.clickOperation(BankAccountFor_Myself);
    }


    public void click_LiveInNetherlands_YES(){

        //Do you live in the Netherlands?

        WebPageOperation.clickOperation(LiveIn_NL);

    }

    public void enter_PostalCode(String postCode){
        //Fill in you postal code and house number.
        WebPageOperation.populateField(Postal_Code,postCode);

    }


    public void enter_HouseNumber(String houseNum){
        //Fill in you postal code and house number.
        WebPageOperation.populateField(HouseNumber,houseNum);

    }

    public void click_NextButton_TellWhoUr(){
        //click on next button 'Tell us who you are'
        WebPageOperation.clickOperation(TellUsWhoUr_Button);

    }


    public void click_BankingProducts_BusinessPurpose(){

        //Are you going to use the banking products for private or business purposes? - business

        WebPageOperation.clickOperation(BankProduct_Business);
    }

    public void get_BankingProducts_BusinessPurpose_linkText(String BusinesslinkText){

        // business account text link

        String Txt= WebPageOperation.getObjText(BusinessAcc_LinkText);

        System.out.println("Business account text link from UI  : "+Txt);
        assertEquals(Txt, BusinesslinkText);
    }


    public void get_WrongPostalcode_WarningText(){

        // wrong housenumber Errortext

        String UITxt= WebPageOperation.getText(Wrong_HouseNumberError);

        System.out.println("Wrong Postal code Warning Text from UI  : "+UITxt);
        assertEquals(UITxt, testdata.ErrorTxtForPostalCode);
    }




}
