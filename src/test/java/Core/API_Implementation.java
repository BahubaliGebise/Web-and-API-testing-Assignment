package Core;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static Util.TestBaseClass.testdata;
import static org.junit.Assert.assertEquals;

public class API_Implementation extends ReadTestCaseData_Implementation  {
    Response resp;
    String query;

    public void API_PostCallRegisterSuccess(String RespCode){

        System.out.println("Connecting to URL : "+testdata.PostURL);
        query = "{\"email\":\""+testdata.emailAddress+"\",\"password\":\""+testdata.passWordLogic+"\"}";
        System.out.println("Json Quary : "+query);

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .when().post(testdata.PostURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        System.out.println("Expected status code :" +RespCode);
        System.out.println("Response Message:" +resp.asString());

        assertEquals(200, resp.getStatusCode());

    }


    public void API_PostCallRegisterUnSuccess(String RespCode){

        System.out.println("Connecting to URL : "+testdata.PostURL);
        query = "{\"email\":\""+testdata.emailAddress+"\"}";
        System.out.println("Json Quary : "+query);

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .when().post(testdata.PostURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        System.out.println("Expected status code :" +RespCode);
        System.out.println("Response Message:" +resp.asString());

        assertEquals(400, resp.getStatusCode());
    }


    public void API_GetCall(String RespCode){


        System.out.println("Connecting to URL : "+testdata.GetURL);

        resp= RestAssured.given()
                .header("Content-Type","application/json")
                .when().get(testdata.GetURL);

        System.out.println("status code from API :" +resp.getStatusCode());
        System.out.println("Response Message:" +resp.prettyPrint());

        assertEquals(200, resp.getStatusCode());

    }

    public void API_PutUserandDeleteUser() throws InterruptedException {

        System.out.println("Connecting to URL : "+testdata.PutURL);
        query = "{\"name\":\"Bahu\",\"job\":\"Engineer\"}";

        resp= RestAssured.given().body(query)
                .header("Content-Type","application/json")
                .when().put(testdata.PutURL);

        System.out.println("status code from API :" +resp.getStatusCode());

        System.out.println("Response Message after PUT Call:" +resp.asString());

        assertEquals(200, resp.getStatusCode());

        Thread.sleep(3000);

        Response resp2= RestAssured.given()
                .body("{\"name\":\"Bahu\"}")
                .header("Content-Type","application/json")
                .when().delete(testdata.PutURL);

        System.out.println("status code from API :" +resp2.getStatusCode());
        System.out.println("Response Message after PUT Call:" +resp2.asString());
    }

}
