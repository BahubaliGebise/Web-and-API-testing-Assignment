package Core;

import Util.ReadFromCSV;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;


public class ReadTestCaseData_Implementation {
    public static WebDriver driver;
    public static Properties prop;
    public String env;
    public String ScenarioType;
    public String userNameLogin;
    public String passWordLogic;
    public String titleName;
    public String FirstName;
    public String lastName;
    public String address;
    public String city;
    public String zipCode;
    public String telNum;
    public String selectService;
    public String userAge;
    public String carAge;
    public String emailAddress;
    public String PostURL;
    public String GetURL;
    public String PutURL;

    public void initialize_testcases(String testcaseID) throws InterruptedException {

        // .csv file name and reading rows and columns(key, value pair)
        String csvFileName = "Input_TestData.csv";
        ReadFromCSV csvReader = new ReadFromCSV(csvFileName);
        ScenarioType = csvReader.readValue(testcaseID, "ScenarioType");
        PostURL = csvReader.readValue(testcaseID, "PostURL");
        GetURL = csvReader.readValue(testcaseID, "GetURL");
        PutURL = csvReader.readValue(testcaseID, "PutURL");

        env = csvReader.readValue("Environment", "UI_URL");

      if(ScenarioType.equalsIgnoreCase("UIScenario")){

        System.out.println("Initialise chrome ");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(env);

        Thread.sleep(3000);

        System.out.println("Chrome Browser launched");

        System.out.println("Reading data from .csv file name  :" + csvFileName);


        userNameLogin = csvReader.readValue(testcaseID, "userNameLogin");

        passWordLogic = csvReader.readValue(testcaseID, "passWordLogic");

        titleName = csvReader.readValue(testcaseID, "titleName");

        FirstName = csvReader.readValue(testcaseID, "FirstName");

        lastName = csvReader.readValue(testcaseID, "lastName");

        address = csvReader.readValue(testcaseID, "address");

        city = csvReader.readValue(testcaseID, "city");
        zipCode = csvReader.readValue(testcaseID, "zipCode");
        telNum = csvReader.readValue(testcaseID, "telNum");
        selectService = csvReader.readValue(testcaseID, "selectService");
        userAge = csvReader.readValue(testcaseID, "userAge");
        carAge = csvReader.readValue(testcaseID, "carAge");
        emailAddress= csvReader.readValue(testcaseID, "emailAddress");

      }else if(ScenarioType.equalsIgnoreCase("APIScenarios")){
          emailAddress= csvReader.readValue(testcaseID, "emailAddress");
          passWordLogic = csvReader.readValue(testcaseID, "passWordLogic");
        }

    }
}
