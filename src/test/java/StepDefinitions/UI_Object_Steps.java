package StepDefinitions;

import Core.ReadTestCaseData_Implementation;
import Core.UI_Object_Implementation;
import Util.WebPageOperation;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.fail;
import static Util.TestBaseClass.testdata;

public class UI_Object_Steps extends ReadTestCaseData_Implementation {

    UI_Object_Implementation UI_Object_ImplementationObj;




    @When("^logic with valid user name$")
    public void logic_with_valid_user_name() throws InterruptedException {

        UI_Object_ImplementationObj= new UI_Object_Implementation(driver);
        Thread.sleep(3000);

        try{

            UI_Object_ImplementationObj.enter_UserName(testdata.userNameLogin);

            Thread.sleep(2000);

            UI_Object_ImplementationObj.enter_Password(testdata.passWordLogic);

            Thread.sleep(2000);

            UI_Object_ImplementationObj.click_LogicButton();


        }catch(Exception e){
            System.out.println("\n could not fine element");
            fail();
        }

    }


    @Then("^verify user login details$")
    public void verify_user_login_details() throws InterruptedException {
        UI_Object_ImplementationObj= new UI_Object_Implementation(driver);
        Thread.sleep(3000);

        try{

            UI_Object_ImplementationObj.confirm_LoginSuccess();

        }catch(Exception e){
            System.out.println("\n could not fine element");
            fail();
        }

    }


    @When("^provide contact us flow details$")
    public void provide_contact_us_flow_details() throws InterruptedException {

        UI_Object_ImplementationObj= new UI_Object_Implementation(driver);


        try{

            Thread.sleep(4000);

            UI_Object_ImplementationObj.click_ContactUS();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.enter_NameTitle(testdata.titleName);

            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_Firstname(testdata.FirstName);

            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_LastName(testdata.lastName);

            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_AddressDetails(testdata.address);


            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_CityDetails(testdata.city);

            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_zipcodeDetails(testdata.zipCode);

            Thread.sleep(1000);
            UI_Object_ImplementationObj.enter_telPhoneNumber(testdata.telNum);

            Thread.sleep(1000);
            String txtMsg="please resolve issue on priority";
            UI_Object_ImplementationObj.enter_textCommentDetails(txtMsg);


            Thread.sleep(1000);
            UI_Object_ImplementationObj.click_SubmitBtn();





        }catch(Exception e){
            System.out.println("\n could not fine element");

        }

    }

    @When("^user select 'Auto quote' service$")
    public void user_select_Auto_quote_service() throws InterruptedException {
        UI_Object_ImplementationObj= new UI_Object_Implementation(driver);
        Thread.sleep(5000);

        try{

            UI_Object_ImplementationObj.select_sevice(testdata.selectService);

        }catch(Exception e){
            System.out.println("\n could not fine element");
            fail();
        }

    }

    @Then("^user provide required details to purchase AutoQuote service$")
    public void user_provide_required_details_topurchase_AutoQuote_service() throws InterruptedException {

        UI_Object_ImplementationObj= new UI_Object_Implementation(driver);


        try{
            Thread.sleep(5000);

            String zipcode=testdata.zipCode;

            UI_Object_ImplementationObj.enter_zipcode(zipcode);

            Thread.sleep(5000);
            String EmailID=testdata.emailAddress;
            UI_Object_ImplementationObj.enter_emailID(EmailID);

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_RadioButton();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_NextButton();

            Thread.sleep(2000);
            String UserAGE=testdata.userAge;
            UI_Object_ImplementationObj.enter_UserAge(UserAGE);

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_UserGender();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_UserHistoryRadioBtn();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_NextButton();

            Thread.sleep(2000);
            String CarAGE=testdata.carAge;
            UI_Object_ImplementationObj.enter_CarAge(CarAGE);

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_DropDown_CarMaking();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.select_CarMaking();

            Thread.sleep(1000);
            UI_Object_ImplementationObj.click_DropDown_CarModel();

            Thread.sleep(2000);

            UI_Object_ImplementationObj.select_CarModel();

            Thread.sleep(2000);

            UI_Object_ImplementationObj.click_RadioBtnFinancial();

            Thread.sleep(2000);
            UI_Object_ImplementationObj.click_NextButton();

            Thread.sleep(5000);
            UI_Object_ImplementationObj.click_purchase();


        }catch(Exception e){
            System.out.println("\n could not fine element");

        }

    }
}
