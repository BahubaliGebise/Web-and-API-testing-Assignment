package StepDefinitions;

import Core.API_Implementation;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class API_step {

API_Implementation serviceCall= new API_Implementation();

    @When("^user post the request and verify status code \"([^\"]*)\"$")
    public void user_post_the_request_and_verify_status_code(String statuscode) {

        if (statuscode.equalsIgnoreCase("400")) {
            serviceCall.API_PostCallRegisterUnSuccess(statuscode);
        }
        else{
            serviceCall.API_PostCallRegisterSuccess(statuscode);
        }

    }

    @Then("^user fetch list of users on a page and verify status code \"([^\"]*)\"$")
    public void user_fetch_list_of_users_on_a_page_and_verify_status_code(String statuscode) {
        serviceCall.API_GetCall(statuscode);
    }

  /*  @When("^user post the request and verify status code \"([^\"]*)\"$")
    public void user_post_the_request_and_verify_status_code(String statuscode) {

        if (statuscode.equalsIgnoreCase("400")) {
            serviceCall.API_PostCallRegisterUnSuccess(statuscode);
        }
        else{
            serviceCall.API_PostCallRegisterSuccess(statuscode);
        }

    }*/

    @When("^create new user with PUT request and delete same user$")
    public void create_new_user_with_PUT_request_and_delete_same_user() throws InterruptedException {

        serviceCall.API_PutUserandDeleteUser();
    }
}
