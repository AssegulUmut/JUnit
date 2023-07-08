package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {
            /*
    1-Driver oluşturalim
    2-Java class'imiza chnomedriver. exetyi tanitalim
    3-Driver'in tum ekranı kaplamasini sagu ayalim
    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
     Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
    5-Navigate to http://www.babayigit.net/murat/testpage.html
    6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        alanlarına gerekli bilgileri yazsın
    7-Submit tuşuna bassın.
    8- All information was entered correctly.. yazısının göründüğünü test etsin ve Test sonucunu yazdırsın
    9- Clear butonu ile tüm butonları temizlesin
    10- Manuel olarak temizlendiğini görecek kadar beklesin
    11- Sayfayı kapatsın
     */
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));
        driver.get("http://www.babayigit.net/murat/testpage.html");

        driver.findElement(By.id("ad")).sendKeys("Murat");
        driver.findElement(By.id("soyad")).sendKeys("Yiğit");
        driver.findElement(By.id("yas")).sendKeys("41");
        driver.findElement(By.id("meslek")).sendKeys("Öğretmen");
        driver.findElement(By.id("dogum_yeri")).sendKeys("İstanbul");
        driver.findElement(By.id("mezun_okul")).sendKeys("Boğaziçi");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("2");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        String uyari="All information was entered correctly..";
        if (driver.findElement(By.id("uyari")).getText().equals(uyari)){
            System.out.println("All information was entered correctly.. Uyarisi Görüntülendi");
            System.out.println("Test Passed");
        }else{
            System.out.println("All information was entered correctly...yazısı Görüntülenemedi.\n Test Failed");
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@type='reset']")).click();
        Thread.sleep(1000);

        driver.quit();

    }
}