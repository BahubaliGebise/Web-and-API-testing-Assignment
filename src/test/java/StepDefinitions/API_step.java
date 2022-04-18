package StepDefinitions;

import CoreLogic.API_Implementation;

import io.cucumber.java.en.*;




public class API_step {

    API_Implementation serviceCall= new API_Implementation();


    @When("executing GET call to fetch project details")
    public void executing_GET_call_to_fetch_project_details() {

        serviceCall.GETMethod_FetchProjectDetails();
    }

    @When("executing POST call to create new issue")
    public void executing_post_call_to_create_new_issue() {

        serviceCall.PostMethod_CreateNewIssue();
    }


    @Then("a status code {string} response is returned")
    public void a_status_code_response_is_returned(String Expected_statusCode) {
        serviceCall.Verify_status_code(Expected_statusCode);

    }

    @Then("verify project details from response")
    public void verify_project_details_from_response() {
        serviceCall.Verify_GETMethodResponse();
    }


    @Then("verify TITLE new value from response")
    public void verify_TITLE_new_value_from_response() {
            serviceCall.Verify_PostMethodResponse();
    }


    @When("executing PUT call to update the issue by providing the {string} and {string}")
    public void executing_put_call_to_update_the_issue_by_providing_the_and(String projectNum, String issueNum) throws InterruptedException {
        String PUT_URL=projectNum+issueNum;
        System.out.println("Update issue API, PUT method : "+PUT_URL );
        serviceCall.PutMethod_ToUpdateIssues(PUT_URL);

    }



    @Then("verify Description and IssueType value from response")
    public void verify_Description_and_IssueType_value_from_response() {

        serviceCall.Verify_PutMethodResponse();
    }

    @When("executing DELETE call to delete an issue")
    public void executing_DELETE_call_to_delete_an_issue() {
             serviceCall.DeleteMethod_ToDeleteIssue();
    }


    @When("execute GET call to verify issue has been deleted")
    public void execute_GET_call_to_verify_issue_has_been_deleted() {
        serviceCall.GETMethod_ToConfirmIssueDeleted();
    }





}
