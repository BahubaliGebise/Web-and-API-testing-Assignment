package StepDefinitions;

import Util.TestBaseClass;

import io.cucumber.java.en.*;

import java.io.IOException;



public class ReadTestCaseData_Step extends TestBaseClass {


    @Given("that the base URL of {string} is set")
    public void that_the_base_url_of_is_set(String App_type) throws IOException, InterruptedException {

        testdata.DefaultInitialiser(App_type);

    }

    @Given("^User is able to launch URL of bank application and the application type is \"([^\"]*)\"$")
    public void User_is_able_to_launch_bank_application_and_the_application_type_is(String AppType) throws InterruptedException, IOException {

        testdata.DefaultInitialiser(AppType);

    }

    @Given("^User is able to create issue and the application type is \"([^\"]*)\"$")
    public void User_is_able_to_launch_bankand_the_application_type_is(String AppType) throws InterruptedException, IOException {

        testdata.DefaultInitialiser(AppType);

    }





}
