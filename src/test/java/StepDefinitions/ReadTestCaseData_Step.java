package StepDefinitions;

import Util.TestBaseClass;
import cucumber.api.java.en.Given;

public class ReadTestCaseData_Step extends TestBaseClass {


    @Given("^the test case id is \"([^\"]*)\"$")
    public void the_test_case_ID_is(String TestID) throws InterruptedException {

        testdata.initialize_testcases(TestID);
    }

}
