package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P_08 {
    //https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
    //Ülke menüsünü locate edin
    //Türkiye Seçeneğini seçin
    //Go to website butonuna tıklayın
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();}


    @Test
    public void AmazonCountryTest() {
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");
        WebElement ulkeSecim= driver.findElement(By.xpath("//*[@class='a-dropdown-prompt']"));
        ulkeSecim.click();
        WebElement Turkiye=driver.findElement(By.xpath("//*[@id='icp-dropdown_18']"));
        Turkiye.click();

    }
}