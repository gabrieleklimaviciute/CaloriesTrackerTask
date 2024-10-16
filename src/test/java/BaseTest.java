import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void openPage(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://practice.expandtesting.com/tracalorie/");
        driver.manage().window().maximize();
    }
//    @AfterEach
//    void tearDown(){
//        if (driver != null) {
//            driver.quit();
//        }
  //  }
}
