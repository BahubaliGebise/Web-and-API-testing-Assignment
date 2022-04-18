package CoreLogic;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static Util.TestBaseClass.testdata;
import static org.junit.Assert.assertEquals;

public class API_Implementation extends ReadTestCaseData_Implementation  {
    Response resp;
    String query;
    static String FinalURL;
    static String NewIssue_iidNum;
    String ResponseStatusCode;

    public void GETMethod_FetchProjectDetails(){

        FinalURL =testdata.api_BaseUrl+testdata.NewProject_ID;

        System.out.println("GET API URL  : "+FinalURL);

        resp  = RestAssured.given().auth().oauth2(testdata.API_TOKEN)
                .header("Content-Type","application/json")
                .when().get(FinalURL);

        System.out.println("Response status code from API :" +resp.getStatusCode());
        System.out.println("Response Message:" +resp.prettyPrint());
        ResponseStatusCode= String.valueOf(resp.getStatusCode());

    }





    public void PostMethod_CreateNewIssue(){

        //forming API URL
        FinalURL = testdata.api_BaseUrl+testdata.newIssuePath;


        System.out.println("Post API- API Url created : "+FinalURL);
        query = "{\"title\":\""+testdata.newIssueBodyPost+"\"}";
        System.out.println("Json Quary : "+query);

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .auth().oauth2(testdata.API_TOKEN)
                .when().post(FinalURL);


        System.out.println("status code from API :" +resp.getStatusCode());

        ResponseStatusCode= String.valueOf(resp.getStatusCode());

        System.out.println("Response Message:" +resp.prettyPrint());


    }

    public void FetchDataFromResponse(){
            NewIssue_iidNum = resp.jsonPath().getString("iid");
            System.out.println("from Post method newly created IID_Number from Response  : " +NewIssue_iidNum);

            }


    public void PutMethod_ToUpdateIssues(String PartialURL) {

        // forming API URL
        FinalURL = testdata.api_BaseUrl+PartialURL;

        System.out.println("Put API- API Url created : "+FinalURL);
        query = "{\"description\":\""+testdata.Description_Val+"\",\"issue_type\":\""+testdata.Issue_Type+"\"}";

        System.out.println("Json Request : "+query);

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .auth().oauth2(testdata.API_TOKEN)
                .when().put(FinalURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        ResponseStatusCode= String.valueOf(resp.getStatusCode());

        System.out.println("Response Message after PUT Call:" +resp.prettyPrint());


    }


    public void PutMethod_ToUpdateDeletedIssues(String PartialURL) {


        // forming API URL with new issue iidNUmber
        FinalURL = testdata.api_BaseUrl+PartialURL+NewIssue_iidNum;

        System.out.println("Put API- API Url created : "+FinalURL);
        query = "{\"description\":\""+testdata.Description_Val+"\",\"issue_type\":\""+testdata.Issue_Type+"\"}";

        System.out.println("Json Request : "+query);

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .auth().oauth2(testdata.API_TOKEN)
                .when().put(FinalURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        ResponseStatusCode= String.valueOf(resp.getStatusCode());

        System.out.println("Response Message after PUT Call:" +resp.prettyPrint());

    }




    public void DeleteMethod_ToDeleteIssue(){

        // forming DELETE API URL
        FinalURL = testdata.api_BaseUrl+testdata.DeleteIssue_PartialURL+NewIssue_iidNum;

        System.out.println("DELETE API- API Url created : "+FinalURL);


        resp= RestAssured.given()
                .header("Content-Type","application/json")
                .auth().oauth2(testdata.API_TOKEN)
                .when().delete(FinalURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        ResponseStatusCode= String.valueOf(resp.getStatusCode());


    }

    public void GETMethod_ToConfirmIssueDeleted() {

        // forming DELETE API URL
        FinalURL = testdata.api_BaseUrl + testdata.DeleteIssue_PartialURL+NewIssue_iidNum;

        System.out.println("GET API- API Url created to fetch deleted issue : " + FinalURL);

        resp= RestAssured.given()
                .header("Content-Type","application/json")
                .auth().oauth2(testdata.API_TOKEN)
                .when().get(FinalURL);

        System.out.println("Response status code from API :" +resp.getStatusCode());
        ResponseStatusCode= String.valueOf(resp.getStatusCode());
    }

    // Response Assertion

    public void Verify_status_code(String Expected_statusCode) {

        System.out.println("status code from API :" +resp.getStatusCode());
        assertEquals(Expected_statusCode, ResponseStatusCode);
    }


    public void Verify_PostMethodResponse() {

        String respTitle_val= resp.jsonPath().getString("title");
        System.out.println("Response Message  : " +respTitle_val);

        assertEquals(testdata.newIssueBodyPost, respTitle_val);
    }


    public void Verify_GETMethodResponse(){
        //assertion on projectID
        String projectID= resp.jsonPath().getString("id");
        System.out.println("Project ID from Response  : " +projectID);
        assertEquals(testdata.ProjectID_Resp , projectID);

        //assertion on visibility
        String visibility_val= resp.jsonPath().getString("visibility");
        System.out.println("From Response visibility value  : " +visibility_val);
        assertEquals(testdata.Visiblity_Val , visibility_val);
    }


    public void Verify_PutMethodResponse() {

        // assertion on description value
        String description_val= resp.jsonPath().getString("description");
        System.out.println("Response description Message  : " +description_val);
        assertEquals(testdata.Description_Val , description_val);

        // assertion on issue_type value
        String issueType_val= resp.jsonPath().getString("issue_type");
        System.out.println("Response issueType value  : " +issueType_val);
        assertEquals(testdata.Issue_Type , issueType_val);

    }

}
