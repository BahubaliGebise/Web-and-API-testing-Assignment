package Core;

import Util.WebPageOperation;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Util.TestBaseClass.testdata;
import static org.junit.Assert.assertEquals;

public class UI_Object_Implementation {

    @FindBy(xpath= "//*[@id=\"login-form:email\"]")
    WebElement userID;

    @FindBy(xpath= "//*[@id=\"login-form:password\"]")
    WebElement password;

    @FindBy(xpath= "//*[@id=\"login-form:login\"]")
    WebElement logicButoon;

    @FindBy(xpath= "//*[@id=\"logout-form\"]/div[2]/label")
    WebElement checkLoginSuccess; 


    @FindBy(xpath= "//*[@id='quick-link:jump-menu']")
    WebElement SelectService;

    @FindBy(xpath= "//*[@id=\"autoquote:zipcode\"]")
    WebElement zipcode;

    @FindBy(xpath= "//*[@id=\"autoquote:e-mail\"]")
    WebElement emailID;

    @FindBy(xpath= "//*[@id=\"autoquote:vehicle:0\"]")
    WebElement carRadiobutton;

         // "//*[@id='autoquote:next']"
    @FindBy(xpath= "//*[@id=\"autoquote:next\"]")
    WebElement Nextbutton;

    @FindBy(xpath= "//*[@id=\"autoquote:age\"]")
    WebElement UserAge;

    @FindBy(xpath= "//*[@id=\"autoquote:gender:0\"]")
    WebElement UserGender;

    @FindBy(xpath= "//*[@id=\"autoquote:type:0\"]")
    WebElement UserHistory;

    @FindBy(xpath= "//*[@id=\"autoquote:year\"]")
    WebElement CarAge;

    @FindBy(xpath= "//*[@id=\"ext-gen4\"]")
    WebElement DropDown_CarMaking_click;

    //@FindBy(xpath= "/html/body/div[1]/div[4]/form/fieldset/div[3]/div[1]/div/div/img")
    @FindBy(xpath= "//*[@id=\"ext-gen6\"]")
    //@FindBy(xpath="//*[@id=\"modelCombo\"]")
    WebElement DropDown_CarModel_click;

    @FindBy(xpath= "//*[@id=\"ext-gen12\"]")
    WebElement DropDown_CarModel;

    @FindBy(xpath= "//*[@id='autoquote:finInfo:1']")
    WebElement RadioBtn_financial;

    @FindBy(xpath= "//*[@id=\"quote-result:purchase-quote\"]")
    WebElement Btn_purchase;

    @FindBy(xpath= "//*[@id=\"autoquote:f1\"]")
    WebElement enter_Title;

    @FindBy(xpath= "//*[@id=\"autoquote:f2\"]")
    WebElement enter_Fstname;

    @FindBy(xpath= "//*[@id=\"autoquote:f3\"]")
    WebElement enter_Lastname;

    @FindBy(xpath= "//*[@id=\"autoquote:f5\"]")
    WebElement enter_Address;

    @FindBy(xpath= "//*[@id=\"contact\"]/a")
    WebElement click_ContactUs;

    @FindBy(xpath= "//*[@id=\"autoquote:f7\"]")
    WebElement enter_city;

    @FindBy(xpath= "//*[@id=\"autoquote:f9\"]")
    WebElement enter_zipcode;

    @FindBy(xpath= "//*[@id=\"autoquote:f10\"]")
    WebElement enter_telPhoneNum;

    @FindBy(xpath= "//*[@id=\"autoquote:f12\"]")
    WebElement enter_textComment;

    @FindBy(xpath= "//*[@id=\"autoquote\"]/fieldset/div[11]/a/img")
    WebElement click_SubmitButton;


    @FindBy(xpath= "//*[@id=\"login-messages\"]/table/tbody/tr/td")
    WebElement get_TextMsg;




    public UI_Object_Implementation(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @Step
    public void enter_UserName( String uName){

        WebPageOperation.populateField(userID,uName);
    }

    @Step
    public void enter_Password( String PWD){

        WebPageOperation.populateField(password,PWD);
    }

    @Step
    public void confirm_LoginSuccess(){

       if( WebPageOperation.isElementPresent(checkLoginSuccess)){

           System.out.println("Login is success with valid customer");

       }
       else {
           System.out.println("Invalid User Name Login");
           String textObjMsg= WebPageOperation.getObjText(get_TextMsg);
           System.out.println("Message from UI screen : "+textObjMsg);
           assertEquals(textObjMsg, "Non-existing email, please try again.");
       }
    }





    @Step
    public void click_LogicButton(){

        WebPageOperation.clickOperation(logicButoon);
    }



    @Step
    public void select_sevice( String abc){
        WebPageOperation.selectDropDownElement(SelectService,abc);
    }

    @Step
    public void enter_zipcode( String zipcodeValue){
        WebPageOperation.populateField(zipcode,zipcodeValue);
    }

    @Step
    public void enter_emailID( String emailID_Value){
        WebPageOperation.populateField(emailID,emailID_Value);
    }

    @Step
    public void click_RadioButton(){
        WebPageOperation.clickOperation(carRadiobutton);
    }


    @Step
    public void click_NextButton() throws InterruptedException {
        Thread.sleep(4000);
        WebPageOperation.clickOperation(Nextbutton);
    }


    @Step
    public void enter_UserAge( String uAge){

        WebPageOperation.populateField(UserAge,uAge);
    }

    @Step
    public void click_UserGender(){
        WebPageOperation.clickOperation(UserGender);
    }



    @Step
    public void click_UserHistoryRadioBtn(){
        WebPageOperation.clickOperation(UserHistory);
    }


    @Step
    public void enter_CarAge( String carAge){

        WebPageOperation.populateField(CarAge,carAge);
    }

    @Step
    public void select_CarMaking(){

        WebPageOperation.selectDropDownElementCarMaking();
    }
    @Step
    public void click_DropDown_CarMaking(){
        WebPageOperation.clickOperation(DropDown_CarMaking_click);

    }


    @Step
    public void click_DropDown_CarModel(){
        //WebPageOperation.populateField(DropDown_CarModel_click," Century");
        //WebPageOperation.clickOperation(DropDown_CarModel_click);
        WebPageOperation.clickDropDownElementCarModel();
    }

    @Step
    public void select_CarModel(){

        WebPageOperation.selectDropDownElementCarModel();
    }


    @Step
    public void click_RadioBtnFinancial() throws InterruptedException {
        Thread.sleep(8000);
        WebPageOperation.clickOperation(RadioBtn_financial);
    }

    @Step
    public void click_purchase(){
        WebPageOperation.clickOperation(Btn_purchase);
    }




    @Step
    public void enter_NameTitle( String title){

        WebPageOperation.populateField(enter_Title,title);
    }

    @Step
    public void enter_Firstname( String Name){

        WebPageOperation.populateField(enter_Fstname,Name);
    }

    @Step
    public void enter_LastName( String LName){

        WebPageOperation.populateField(enter_Lastname,LName);
    }

    @Step
    public void enter_AddressDetails( String addres){

        WebPageOperation.populateField(enter_Address,addres);
    }

    @Step
    public void click_ContactUS( ){

        WebPageOperation.clickOperation(click_ContactUs);
    }

    @Step
    public void enter_CityDetails( String city){

        WebPageOperation.populateField(enter_city,city);
    }


    @Step
    public void enter_zipcodeDetails( String zipcode){

        WebPageOperation.populateField(enter_zipcode,zipcode);
    }

    @Step
    public void enter_telPhoneNumber( String telPhoneNum){

        WebPageOperation.populateField(enter_telPhoneNum,telPhoneNum);
    }


    @Step
    public void enter_textCommentDetails( String textComment){

        WebPageOperation.populateField(enter_textComment,textComment);
    }

    @Step
    public void click_SubmitBtn( ){

        WebPageOperation.clickOperation(click_SubmitButton);
    }

}

