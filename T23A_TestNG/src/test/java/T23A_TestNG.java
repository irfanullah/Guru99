import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class T23A_TestNG {

    public WebDriver driver;
    String BaseUrl = "http://demo.guru99.com/test/newtours/";
    public String expected = null;
    public String actual = null;
    @BeforeTest
    public void launchBrowser ()
    {
        System.out.println("Launching Firefox browser");
        FirefoxDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(BaseUrl);
    }
    @BeforeMethod
    public void verifyHomepageTitle()
    {
        expected = "Welcome: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(expected, actual);
    }
    @Test(priority = 0)
    public void clickRegister()
    {
        driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(expected,actual);

    }
    @Test(priority = 1)
    public void support()
    {
        driver.findElement(By.linkText("SUPPORT")).click();
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(expected,actual);
    }
    @AfterMethod
    public void gobackToHomepage()
    {
        driver.findElement(By.linkText("Home")).click();
    }

    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }

}
