  
Candidate Name- Bahubali Gebise.
Framework : Test Automation project with Cucumber-BDD framework along with Serenity report.
  
Please find below scenarios details :
  
  |-------------|-----------------------------------------------------------------------------------|
  |TestCase ID  |                           **Scenarios Name**                                      |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC01      |              Apply for auto quote service                                         |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC02      |              Contact us flow                                                      |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC03      |              UI Login validation                                                  |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC04      |              Post request-Register Successful.                                    |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC05      |              Post request-Register UnSuccessful.                                  |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC06      |              Fetch a list of Users on a page.                                     |
  |-------------|-----------------------------------------------------------------------------------|
  |   UC07      |              Create a user with POST and delete the same user.                                     |
  |-------------|-----------------------------------------------------------------------------------|
  
 
**Project Details**

 1. Please find below Automation Project basic information:
      A. Scenarios are written at .feature file under 'Feature' folder.
      B. Input parameters reading based on TestCase-ID from Input_TestData.csv file under 'TestData' folder.
      C. Input Data reading logic implemented at ReadFromCSV.java under 'Util' folder.
      D. StepDefinitions files are having methods and logic implemented at Implementation class's (Under 'Core' folder).
    
 2. Run _TestRunner_ file- under TestRunner folder.
    - All feature files under Feature folder will be executed. 
     
 3. We can execute scenarios via Terminal(IDE- intellij) :
    mvn clean verify -Dcucumber.options="src/test/java/Feature"
    and serenity report will be created under target\site\serenity\index.xml .

===========================End=======================================================================