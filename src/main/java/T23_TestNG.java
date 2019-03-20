import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T23_TestNG {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;

    @Test
    public void verifyHomepageTitle(){
        System.out.println("Launching Firefox browser");
        FirefoxDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.close();
    }
}
