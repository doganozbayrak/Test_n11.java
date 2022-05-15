import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Test_n11 extends Base_Test {
    private static final Logger logger = LogManager.getLogger(Test_n11.class);
    @Test
    @Order(1)
    public void test1_url_control(){
        Assertions.assertEquals("https://www.n11.com/",driver.getCurrentUrl());
        logger.info("Anasayfa girişi başarılıdır.");
       /*
       ya da asserttitle ile bulunabilir.
        */
    }
    /*   ÖNEMLİ NOT: Sitede otomasyon login botu olduğu için bu test gerçekleştirilemedi ancak
          güvenlik botu ileride kaldırılırsa yorum satırları kaldırılıp test koşulabilir.
    String mail_Address="seleniumdogan@hotmail.com";
    String passW="Selenium123";
    @Test
    @Order(2)
    public void test2_login_control() throws InterruptedException {
        homePage.girisClick();
        Thread.sleep(2000);
        homePage.seteMail(mail_Address);
        homePage.setPassword(passW);
        Thread.sleep(2000);
        homePage.setLogin_Button();
        Thread.sleep(2000);
        WebElement log_checked=driver.findElement(new By.ByCssSelector("a[class='menuLink user']"));
        Assertions.assertEquals("Selenium Doğan",log_checked.getText());
    }
*/
    @Test
    @Order(2)
    public void test2_search_Product() throws InterruptedException {
        homePage.setSearch("bilgisayar");
        Thread.sleep(2000);
        homePage.page_Two();
        Thread.sleep(1500);
        Assertions.assertEquals("https://www.n11.com/arama?q=bilgisayar&pg=2",driver.getCurrentUrl());
        logger.info("İkinci sayfaya geçilmiştir.");
    }
    @Test
    @Order(3)
    public void test3_price_comparison() throws InterruptedException {
        homePage.random_Product();
        Thread.sleep(1500);
        String fiyat1=driver.findElement(new By.ByCssSelector("div[class='newPrice']>ins")).getText();
        Thread.sleep(1500);
        homePage.add_to_Basket();
        Thread.sleep(1500);
        homePage.go_basket();
        Thread.sleep(1500);
        logger.info("Sepete random ürün eklendi.");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1500);
        String fiyat2=driver.findElement(new By.ByCssSelector("span[class='price']")).getText();
        Thread.sleep(1500);
        Assertions.assertEquals(fiyat1,fiyat2);
        logger.info("Ürün fiyatları uyuşmaktadır.");
    }
    @Test
    @Order(4)
    public void test4_add_more_to_basket() throws InterruptedException {
        homePage.add_oneMore_to_basket();
        Thread.sleep(1500);
        Assertions.assertEquals("2",homePage.two_products_control());
        logger.info("Sepette 2 adet ürün olduğu doğrulanmıştır.");
    }
    @Test
    @Order(5)
    public void test_5_remove_products() throws InterruptedException {
        homePage.remove_Products();
        Thread.sleep(1000);
        Assertions. assertEquals("Sepetiniz Boş",homePage.remove_basket_control());
        logger.info("Sepetin boşaltıldığı doğrulanmıştır.");

        // git deneme yorum satırı
    }
}

