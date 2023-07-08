package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String ht="https://www.";
        driver.get(ht+"google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(ht+"amazon.com");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.navigate().back();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle()); //15BD01E24728D6C2DAEF924FC5E365C4
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht+"wisequarter.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandles()); //[5036E241464441FBBA5B6F33D2DAC1B6, 4E2F07F26678DD092B5391AD8A8E7DD0]
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("http://www.babayigit.net");
        driver.getWindowHandles();
        //driver.close(); //Açılan son pencereyi kapatır.
        driver.quit(); //Açılmış olan tüm pencereleri kapatır.

    }
}