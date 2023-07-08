package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class P04 {
    //Assertion İşlemi
    //https://www.google.com adresine gidip titlee'in google/Google içermediğini/içerdiği test edelim
    @Test
    public void testTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
        String actualTitle=driver.getTitle();
        String expectedIcerik="google";
        String expectedIcerik2="Google";
        Assert.assertFalse(actualTitle.contains(expectedIcerik));
        Assert.assertTrue(actualTitle.contains(expectedIcerik2));
        driver.close();
    }
}
