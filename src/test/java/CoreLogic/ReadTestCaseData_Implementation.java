package CoreLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadTestCaseData_Implementation {
    public static Properties configProp;
    public static FileInputStream ip;



    public static WebDriver driver;
    public static Properties prop;
    public String UI_Env;
    public String api_BaseUrl;
    public String newIssuePath;
    public String passWordLogic;
    public String newIssueBodyPost;
    public String Description_Val;
    public String Issue_Type;
    public String DeleteIssue_PartialURL;
    public String API_TOKEN;
    public String ErrorTxtForPostalCode;
    public String NewProject_ID;
    public String ProjectID_Resp;
    public String Visiblity_Val;
    public String PutURL;
    public String BrowserName;

    public void DefaultInitialiser(String AppType) throws InterruptedException, IOException {


        configProp= new Properties();
        ip= new FileInputStream("src\\test\\resources\\environment.properties");
        configProp.load(ip);

        BrowserName =configProp.getProperty("BrowserType");

        UI_Env = configProp.getProperty("Web_URL");
        ErrorTxtForPostalCode=configProp.getProperty("ErrorTxtPostalCode");


        api_BaseUrl= configProp.getProperty("API_BaseURL");

        NewProject_ID=configProp.getProperty("ProjectID");
        ProjectID_Resp=configProp.getProperty("Project_ID");
        Visiblity_Val=configProp.getProperty("Visibility");
        // read from command line
        API_TOKEN= System.getProperty("apiToken");

        newIssuePath=configProp.getProperty("NewIssue");
        newIssueBodyPost=configProp.getProperty("NewIssuebodyPost");

        Description_Val=configProp.getProperty("DescriptionVal");
        Issue_Type=configProp.getProperty("IssueType");

        DeleteIssue_PartialURL=configProp.getProperty("DeleteIssuePartialURL");



      if(AppType.equalsIgnoreCase("Web")){

        //Driver initialisation logic
          if(BrowserName.equalsIgnoreCase("Chrome")) {
              System.out.println("Initialise chrome driver ");

              System.setProperty("webdriver.chrome.driver", configProp.getProperty("ChromePath"));
              driver = new ChromeDriver();

          }
          else if (BrowserName.equalsIgnoreCase("edge")){
              System.out.println("Initialise edge driver ");
              System.setProperty("webdriver.edge.driver", configProp.getProperty("EdgePath"));
              driver = new EdgeDriver();
          }
          else{
              System.out.println("Enter valid browser name");
          }

        driver.get(UI_Env);

        driver.manage().window().maximize();

        System.out.println("Looking for ABN AMRO cookies accept button to be clickable");

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"aab-cookie-consent-agree\"]"))).click();

        System.out.println("ABN cookies accepted");

        System.out.println("Chrome Browser launched with ABN AMRO Portal");


      }
      else if(AppType.equalsIgnoreCase("API")){
          System.out.println("We are performing API testing ");
        }

    }


}
