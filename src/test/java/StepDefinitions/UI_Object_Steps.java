package StepDefinitions;

import CoreLogic.*;


import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.*;

import java.util.List;


public class UI_Object_Steps extends ReadTestCaseData_Implementation {


    ReadTestCaseData_Implementation obj1=new ReadTestCaseData_Implementation();
    Page_ChooseBankAccount Page_ChooseBankAccount_Objects= new Page_ChooseBankAccount(driver);

    Page_YourDetails Page_YourDetails_Objects = new Page_YourDetails(driver);

    Page_Identifying Page_Identifying_Objects= new Page_Identifying(driver);

    Page_ClosingQuestions Page_ClosingQuestions_Objects = new Page_ClosingQuestions(driver);

    Page_Confirm Page_Confirm_Objects = new Page_Confirm(driver);


    @Given("User choose PRIVATE as a bank products for SELF use")
    public void user_choose_private_as_a_bank_products_for_self_use() {

    //Are you going to use the banking products for private or business purposes?
        Page_ChooseBankAccount_Objects.click_BankingProducts_PrivatePurpose();

    //Who is the bank account for?
        Page_ChooseBankAccount_Objects.click_BankAccountFor_Myself();

    }


    @When("User enters valid address to receive debit card")
    public void user_enters_valid_address_to_receive_debit_card(DataTable table) {



        List<List<String>> data= table.asLists(String.class);

        //Do you live in the Netherlands?
        Page_ChooseBankAccount_Objects.click_LiveInNetherlands_YES();

        for (List<String> datum : data) {
            String FirstValue_PostalCode = datum.get(0);
            String SecondValue_HouseNumber = datum.get(1);
            //Fill in you postal code and house number.
            Page_ChooseBankAccount_Objects.enter_PostalCode(FirstValue_PostalCode);

            //Fill in you postal code and house number.
            Page_ChooseBankAccount_Objects.enter_HouseNumber(SecondValue_HouseNumber);
        }

    }

    @When("User navigates to personal details page")
    public void User_navigates_to_personal_details_page() throws InterruptedException {
        Thread.sleep(3000);
        //click on next button 'Tell us who you are'
        Page_ChooseBankAccount_Objects.click_NextButton_TellWhoUr();
    }

    @Then("User navigates to Your_Details page successfully")
    public void user_navigates_to_YoursDetails_page_successfully() {

        System.out.println("Navigated to Your details page successfully");

    }


    @Then("User enters name, surname and date of birth on Your_Details page")
    public void user_enters_name_surname_and_date_of_birth_on_Your_Details(DataTable tableYourDetails){


        List<List<String>> dataVal= tableYourDetails.asLists(String.class);


        for (List<String> strings : dataVal) {
            String FirstValue_YourSalutation = strings.get(0);
            String FirstValue_Initials = strings.get(1);
            String SecondValue_FirstName = strings.get(2);
            String ThirdValue_Surname = strings.get(3);
            String FourthValue_DateOfBirth = strings.get(4);

            // Your salutation options Mr or Ms
            Page_YourDetails_Objects.click_YourSalutation(FirstValue_YourSalutation);

            // Your initial(s)
            Page_YourDetails_Objects.entire_YourInitials(FirstValue_Initials);

            //Your first names
            Page_YourDetails_Objects.entire_YourFirstName(SecondValue_FirstName);

            //surname
            Page_YourDetails_Objects.enter_YourSurname(ThirdValue_Surname);

            //enter date of birth
            Page_YourDetails_Objects.enter_Your_DOB(FourthValue_DateOfBirth);

        }



    }


    @Then("User enters required details under tax fields with nationality")
    public void user_enters_required_fields_of_tax_details_with_nationality(DataTable tableDutchBSN){

        //Were you born in the USA? - Non_US_Born
        Page_YourDetails_Objects.click_Non_US_Born();

        //What's your nationality? - Dutch nationality
        Page_YourDetails_Objects.select_NationalityDropDown();

        List<List<String>> dataVal= tableDutchBSN.asLists(String.class);


        for (List<String> strings : dataVal) {

            String FirstValue_DutchBSN = strings.get(0);

            //What's your Dutch personal ID number?
            Page_YourDetails_Objects.enter_DutchID_BSN(FirstValue_DutchBSN);
        }

        //Do you only pay tax in the Netherlands? - Yes
        Page_YourDetails_Objects.click_TaxPay_NL();
    }





    @Then("User navigates to Identifying page successfully")
    public void user_navigates_to_IdentifyingPage_successfully(){

        // click on next identification button to navigate to identify page
        Page_YourDetails_Objects.click_ToIdentification_NextButton();

    }

    @Then("User enters form of identification and contact details")
    public void User_enters_form_of_identification_and_contact_details(DataTable tableCOntactDetails) {

    //Which form of identification would you like to use for the verification of your identity?- DUtch Passport.
        Page_Identifying_Objects.click_FormOfIndentification();


        List<List<String>> dataTxt= tableCOntactDetails.asLists(String.class);


        for (List<String> strings : dataTxt) {

            String FirstValue_EmailID = strings.get(0);
            String SecondValue_TelephoneNum = strings.get(1);


            //Your contact details email ID
            Page_Identifying_Objects.entire_Email_contact(FirstValue_EmailID);

            //Your contact details telephone number
            Page_Identifying_Objects.entire_Telephone_contact(SecondValue_TelephoneNum);
        }

    // ToclosingQuestion next button page
        Page_Identifying_Objects.click_ToClosingQuestionNextButton();


    }



    @Given("user enters details of {string}, company {string} , willing to transfer {string} and bank ever {string} details")
    public void user_enters_details_of_company_willing_to_transfer_and_bank_ever_details(String IncomeType_Received, String ownerOrDirector, String transferAbove500k, String isRefused) {

            if(IncomeType_Received.equalsIgnoreCase("Not Applicable")){

      //Do you receive your income mainly from real estate or cryptocurrency trading?-Not Applicable
                Page_ClosingQuestions_Objects.click_Income_NotApplicable();
            }

            if(ownerOrDirector.equalsIgnoreCase("NO")){
      //Are you the owner or director of a company? - No
                Page_ClosingQuestions_Objects.click_Not_OwnerOfCompany();
            }

            if(transferAbove500k.equalsIgnoreCase("NO")){
     // Will you be transferring €500,000 or more to your ABN AMRO current account or savings account - NO
                Page_ClosingQuestions_Objects.click_TransferLessThan_500k();
            }

            if(isRefused.equalsIgnoreCase("NO")){
      // Has a bank or insurer ever refused you or terminated the relationship?- No
                Page_ClosingQuestions_Objects.click_NotRefused();
            }
      // click on Overview next button
        Page_ClosingQuestions_Objects.click_OverviewNextButton();
    }





    @Then("User verifies all input data on Overview screen")
    public void User_verifies_all_input_data_on_Overview_screen(DataTable tableInputDetails){



        List<List<String>> dataTxt= tableInputDetails.asLists(String.class);


        for (List<String> strings : dataTxt) {

            String FirstValue_DOB = strings.get(0);

            String SecondValue_TelephoneNum = strings.get(1);

            String ThirdValue_EmailID = strings.get(2);

            // verify Date of birth, telephone and email ID from overview screen

            Page_Confirm_Objects.get_ConfirmPage_DOB(FirstValue_DOB);

            Page_Confirm_Objects.get_ConfirmPage_Telephone(SecondValue_TelephoneNum);


            Page_Confirm_Objects.getConfirmPage_EmailID(ThirdValue_EmailID);
        }

    // user click on apply button
        Page_Confirm_Objects.ClickApplyButton();


    }

    @Then("User is able to create new account successfully")
    public void User_is_able_to_create_new_account_successfully() {

      // Verify bank accounted successfully

        String text_success="Thank you for choosing ABN AMRO!";
        Page_Confirm_Objects.getAccountCreatedSuccessText(text_success);
    }



    @Given("User choose Business as a bank products")
    public void user_choose_Business_as_a_bank_products(DataTable tableBusinessTxt) {

        //Are you going to use the banking products for private or business purposes? - Business
        Page_ChooseBankAccount_Objects.click_BankingProducts_BusinessPurpose();


        List<List<String>> dataTxt= tableBusinessTxt.asLists(String.class);


        for (List<String> strings : dataTxt) {

            String FirstValue_BusinessTxt = strings.get(0);
            Page_ChooseBankAccount_Objects.get_BankingProducts_BusinessPurpose_linkText(FirstValue_BusinessTxt);
        }
    }


    @When("User enters invalid {string} and house {string} number")
    public void user_enters_invalid_and_house_number(String Postcode, String houseNum)  {

        //Fill in you postal code .
        Page_ChooseBankAccount_Objects.enter_PostalCode(Postcode);

        //wrong house number.
        Page_ChooseBankAccount_Objects.enter_HouseNumber(houseNum);


    }

    @Then("User verify error message for wrong address")
    public void  User_verify_error_message_for_wrong_address() {
        // verify Warning error text on UI

        //String Txt="We do not recognize your postal code. Check if this is the correct zip code. Will it not succeed afterwards? Then we will be happy to help you at 0900 - 00 24 (usual call charges).";
        Page_ChooseBankAccount_Objects.get_WrongPostalcode_WarningText();
    }


    @Then("User verifies error message for wrong email ID")
    public void  User_verifies_error_message_for_wrong_email_ID(DataTable tableErrorMsg) {

        // verify error text on UI

        List<List<String>> dataTxt= tableErrorMsg.asLists(String.class);


        for (List<String> strings : dataTxt) {

            String FirstValue_ErrorEmailTxt = strings.get(0);
            Page_Identifying_Objects.get_Email_ErrorMsg(FirstValue_ErrorEmailTxt);
        }
    }


    @Then("User verifies error message for wrong Telephone number")
    public void  User_verifies_error_message_for_wrong_TelephoneNumber(DataTable tableErrorTeleMsg) {

        // verify error text on UI

        List<List<String>> dataTelephoneTxt= tableErrorTeleMsg.asLists(String.class);


        for (List<String> strings : dataTelephoneTxt) {

            String FirstValue_ErrorTelephoneTxt = strings.get(0);
            Page_Identifying_Objects.get_Telephone_ErrorMsg(FirstValue_ErrorTelephoneTxt);
        }
    }



    @Then("User navigate back to bank account page to update the current postal code")
    public void User_navigate_back_to_bank_account_page_to_update_the_current_postal_code() {

        //Navigate back to previous page(bank account page)

        Page_YourDetails_Objects.NavigateToLastPage_clickBackButton();
    }



    @Then("User clicks tooltip and verifies text message")
    public void  User_clicks_tooltip_and_verifies_text_message() {
        // verify all tool tips form your_details
        Page_YourDetails_Objects.Tooltips_FirstName_SurName();
    }



    @Then("close the application")
    public void  close_the_application() {
        driver.manage().deleteAllCookies();
        driver.quit();
        System.out.println("Application has been closed");
    }

   /* @After
    public void teardown() throws IOException, InterruptedException {

            driver.manage().deleteAllCookies();
            driver.quit();
            System.out.println("Browsers are closed");
        }*/




}
