package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class P09 {
    //JS Alert Kullanımı
    static WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //@After
    //public void tearDown(){driver.close();}
    @Test @Ignore
    public void test01() throws InterruptedException {
        /* 1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        String actualAlert = driver.switchTo().alert().getText();
        String expectedAlert = "I am a JS Alert";
        Assert.assertEquals(expectedAlert, actualAlert);
        //Ok(Tamam) tuşuna basalım
        driver.switchTo().alert().accept();
        String expectedSonucYazisi = "You successfully clicked an alert";
        WebElement sonucyazisi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi = sonucyazisi.getText();
        System.out.println(sonucyazisi.getText());
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);
    }
    @Test @Ignore
    public void test02() throws InterruptedException {
        /*
           - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String expectedConfirmYazisi="You clicked: Cancel";
        WebElement sonucyazisi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualConfirmYazisi=sonucyazisi.getText();
        System.out.println(sonucyazisi.getText());
        Assert.assertEquals(expectedConfirmYazisi,actualConfirmYazisi);
    }
    @Test
    public void test03() throws InterruptedException {
        /*
           3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
     */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("yusufRhmn");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        String expectedConfirmYazisi="You entered: yusufRhmn";
        WebElement sonucyazisi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualConfirmYazisi=sonucyazisi.getText();
        System.out.println(sonucyazisi.getText());
        Assert.assertEquals(expectedConfirmYazisi,actualConfirmYazisi);
    }
}