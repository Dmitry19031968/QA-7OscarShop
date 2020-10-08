import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(option);
//        driver = new ChromeDriver();
//        driver.manage().window().fullscreen();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");

//        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
