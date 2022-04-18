package CoreLogic;
import Util.WebPageOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Page_YourDetails {

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C2-F0-0\"]")
    WebElement YourSalutationMr;


    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C2-F0-1\"]")
    WebElement YourSalutationMs;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C3-F0\"]")
    WebElement YourInitials;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C4-F0\"]")
    WebElement YourFirstName;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C6-C0-F0\"]")
    WebElement YourSurname;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-C8-F0\"]")
    WebElement Your_DOB;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C1-F9-1\"]")
    WebElement Non_US_Born;

//*[@id="dropdown-P390-C2-C0-C4-C1-F0"]/span[1]


    @FindBy(xpath= "//*[@id=\"dropdown-P390-C2-C0-C4-C1-F0\"]/span[1]")
    WebElement Nationality_DropDownBox_click;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C4-C1-F0-62\"]")
    WebElement Nationality_DropDownBox_value;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C4-C3-F0\"]")
    WebElement DutchID_BSN;

    @FindBy(xpath= "//*[@id=\"P390-C2-C0-C4-F5-0\"]")
    WebElement TaxPay_NL;

    @FindBy(xpath= "//*[@id=\"P390-C2-C1-B1\"]/span")
    WebElement ToIdentification_NextButton;


    @FindBy(xpath= "//*[@id=\"P390-C2-C1-B0\"]")
    WebElement NavigatePreviousPage_BackButton;

    @FindBy(xpath= "//*[@id=\"i-text-button-P390-C2-C0-C1-C4-F0\"]")
    WebElement TooltipBtn_FirstName;

    @FindBy(xpath= "//*[@id=\"i-text-button-P390-C2-C0-C1-F9\"]")
    WebElement TooltipBtn_USBorn;


    @FindBy(xpath= "//*[@id=\"i-text-button-P390-C2-C0-C1-C6-C0-F0\"]")
    WebElement TooltipBtn_SurName;


    public Page_YourDetails(WebDriver driver){
        initElems(driver);
    }

    public void initElems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




    public void click_YourSalutation(String salutation){
        if (salutation.equalsIgnoreCase("Mr")) {

            WebPageOperation.clickOperation(YourSalutationMr);
        }
        else if(salutation.equalsIgnoreCase("Ms")){

            WebPageOperation.clickOperation(YourSalutationMs);
        } else{

            System.out.println("Enter Valid your salutation value");
        }
    }

    public void entire_YourInitials(String name_Initials){

        WebPageOperation.populateField(YourInitials,name_Initials);

    }


    public void entire_YourFirstName(String firstName){



        WebPageOperation.populateField(YourFirstName,firstName);

    }

    public void enter_YourSurname(String SurName){

        WebPageOperation.populateField(YourSurname,SurName);

    }


    public void enter_Your_DOB(String dateOfBirth){

        WebPageOperation.populateField(Your_DOB,dateOfBirth);

    }

    public void click_Non_US_Born(){

        WebPageOperation.clickOperation(Non_US_Born);

    }

    public void select_NationalityDropDown(){


        WebPageOperation.clickOperation(Nationality_DropDownBox_click);

        WebPageOperation.clickOperation(Nationality_DropDownBox_value);

    }

    public void enter_DutchID_BSN(String DutchID){


        WebPageOperation.populateField(DutchID_BSN,DutchID);

    }


    public void click_TaxPay_NL(){

        WebPageOperation.clickOperation(TaxPay_NL);

    }



    public void click_ToIdentification_NextButton(){



        WebPageOperation.clickOperation(ToIdentification_NextButton);

    }



    public void NavigateToLastPage_clickBackButton(){


        WebPageOperation.clickOperation(NavigatePreviousPage_BackButton);

    }


    public void Tooltips_FirstName_SurName(){

        WebPageOperation.isElementPresent(TooltipBtn_FirstName);

        WebPageOperation.clickOperation(TooltipBtn_FirstName);


        WebPageOperation.clickOperation(TooltipBtn_SurName);


        WebPageOperation.clickOperation(TooltipBtn_USBorn);

    }

}
