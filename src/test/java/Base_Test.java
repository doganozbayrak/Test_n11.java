import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Base_Test {
    public WebDriverWait wait;
    HomePage homePage;
    protected WebDriver driver;

@BeforeAll
public void setup(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Dogan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://www.n11.com/");
    driver.manage().window().maximize();
    homePage=new HomePage(driver);
    wait = new WebDriverWait(driver, 30);// verilen görevi yapması için 30 saniye bekliyor.

}
@AfterAll
public void tearDown(){
    driver.quit();
}
}

