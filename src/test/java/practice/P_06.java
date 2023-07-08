package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P_06  {
    //https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb adresine gidin
    //Prime Programs kısmındaki ilk 3 checkbox locate edin
    //üç checkbox'ı işaretleyin
    //her üç checkbox'ında işaretli olduğunu doğrulayın
    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){driver.close();}
    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement checkBox3= driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));;
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(3000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(3000);
        if (!checkBox3.isSelected()){
            checkBox3.click();
        }
        Assert.assertTrue(checkBox1.isSelected()&&checkBox2.isSelected()&&checkBox3.isSelected());
    }
}
