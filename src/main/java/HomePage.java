import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriverWait wait;
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 45);
    }

    private final By log = new By.ByCssSelector("a[title='Hesabım']");
    public void girisClick() {
        WebElement log1 = driver.findElement(log);
        log1.click();

    }

    private final By eMail = By.id("email");
    public void seteMail(String mailText) {
        WebElement mail = driver.findElement(eMail);
        mail.sendKeys(mailText);
    }

    private final By password = By.id("password");
    public void setPassword(String passwordText) {
        WebElement passW = driver.findElement(password);
        passW.sendKeys(passwordText);
    }

    private final By logBut=new By.ByCssSelector("div[class='green_flat']");
    public void setLogin_Button() {
        wait.until(ExpectedConditions.elementToBeClickable(logBut)).click();
    }
    private final By search=By.id("searchData");
    private final By search_but=new By.ByCssSelector("span[class='icon iconSearch']");
    public void setSearch(String product){
        WebElement search_space= driver.findElement(search);
        search_space.sendKeys(product);
        WebElement search_Button= driver.findElement(search_but);
        search_Button.click();
    }
    public void page_Two() throws InterruptedException {
        WebElement pageTwo= driver.findElement(By.xpath("//a[text()='2']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        pageTwo.click();
    }
    public void random_Product() throws InterruptedException {
        List<WebElement> select_Product = driver.findElements(new By.ByCssSelector(".productName"));
        int rand = (int) (Math.random() * select_Product.size() + 1);
        System.out.println("Random "+rand+". ürün sepete eklendi");
        select_Product.get(rand).click();
        Thread.sleep(1500);
    }
    private final By add_t_basket=new By.ByCssSelector("a[title='Sepete Ekle']");
    public void add_to_Basket() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(1500);
            WebElement add = driver.findElement(add_t_basket);
            add.click();
            Thread.sleep(2000);
    }
    private final By accept_cookies=new By.ByCssSelector("span[class='btn btnBlack']");
    public void go_basket() throws InterruptedException {
        WebElement go= driver.findElement(new By.ByCssSelector("a[title='Sepetim']"));
        go.click();
        WebElement accept_Cookies= driver.findElement(accept_cookies);
        accept_Cookies.click();
        Thread.sleep(1500);
    }
    private final By add_product=new By.ByCssSelector("span[class='spinnerUp spinnerArrow']");
    public void add_oneMore_to_basket() throws InterruptedException {
       // Thread.sleep(2000);
        WebElement add_one_more= driver.findElement(add_product);
        add_one_more.click();
        Thread.sleep(2000);
    }
    private final By two_products_checked=new By.ByXPath("(//input[@type='text'])[1]");
    public String two_products_control(){
        WebElement two_checkhed= driver.findElement(two_products_checked);
        two_checkhed.click();
        return two_checkhed.getAttribute("value");
    }
    private final By remove=new By.ByCssSelector("span[title='Sil']");
    public void remove_Products() throws InterruptedException {
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);
        WebElement remove_products= driver.findElement(remove);
        remove_products.click();
    }
    private final By remove_control=new By.ByCssSelector("div[class='cartEmptyText']>h2");
    public String remove_basket_control(){
        WebElement control_remove= driver.findElement(remove_control);
        return control_remove.getText();
    }
}
