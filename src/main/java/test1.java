import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
public class test1 {



    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver obj = new ChromeDriver();
        obj.get ("https://www.aodocs.com");


        //click request a demo button


        obj.findElement(By.xpath("//*[@id=\"DND_banner-module-1\"]/div/div/div[1]/div/div/a")).click();

        //enter first name

        TimeUnit.SECONDS.sleep(10);

        obj.findElement(By.name("firstname")).sendKeys("Darine");

        //Make random email
        String RandomEmail = UUID.randomUUID().toString();

        //Now this uuid enter to your text box
        TimeUnit.SECONDS.sleep(10);
        obj.findElement(By.name("email")).sendKeys(RandomEmail);




        //Open list
        TimeUnit.SECONDS.sleep(15);

        obj.findElement(By.name("company_size__c")).click();

        //Choose campany size
        TimeUnit.SECONDS.sleep(10);

        obj.findElement(By.xpath("//*[@id=\"company_size__c-384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/option[2]")).click();





        //Click submit
        //e can use also  (WebDriverWait wait = new WebDriverWait(obj, 15);)
        TimeUnit.SECONDS.sleep(10);
        obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/div/div[2]/input")).sendKeys(Keys.ENTER);

        //To Check error messages :

        //Email error msg
        TimeUnit.SECONDS.sleep(10);
        WebElement errMsgElem = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[2]/div[1]/ul/li/label"));
        String errMessage = errMsgElem.getAttribute("innerText");
        String expected_error="Email must be formatted correctly.";
        Assert.assertEquals(errMessage,expected_error);
        System.out.println("Email errors are checked ");

        //Last name msg error
        TimeUnit.SECONDS.sleep(10);
        WebElement errMsgLastName = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[1]/div[3]/ul/li/label"));
        String errMesg = errMsgElem.getAttribute("innerText");


        String expected_errorLastname="Please complete this required field.";
        Assert.assertEquals(errMesg,expected_error);
        System.out.println("last name error is checked");



        //check company msg error

        TimeUnit.SECONDS.sleep(5);
        WebElement errCompanyName = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[3]/div[1]/ul/li/label"));
        String errCompanyMSG = errMsgElem.getAttribute("innerText");


        String expected_errorCompanyName="Please complete this required field.";
        Assert.assertEquals(errCompanyMSG,expected_error);
        System.out.println("Company name error is checked");

        //check country error msg
        TimeUnit.SECONDS.sleep(5);
        WebElement errCountryName = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[4]/div/ul/li/label"));
        String errCountryMSG = errMsgElem.getAttribute("innerText");
        String expected_errorCountryName="Please select an option from the dropdown menu.";
        Assert.assertEquals(errCountryMSG,expected_error);
        System.out.println("Country selection error is checked");


        //check msg field error
        TimeUnit.SECONDS.sleep(5);
        WebElement errMSGFIELD = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[6]/div/ul/li/label"));
        String errMSG = errMsgElem.getAttribute("innerText");
        String expected_errorMSGFIELD="Please complete this required field.";
        Assert.assertEquals(errMSG,expected_error);
        System.out.println("MSG FIELD error is checked");


        //how did you hear about us  eroor msg

        TimeUnit.SECONDS.sleep(5);

        WebElement errSlection = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_8038\"]/fieldset[7]/div/ul/li/label"));
        String errHDYHAU = errMsgElem.getAttribute("innerText");
        String expected_errSelection="Please select an option from the dropdown menu.";
        Assert.assertEquals(errHDYHAU,expected_error);
        System.out.println("HDYHAU error message is checked");

        // Close the browser
        obj.quit();







    }
}
