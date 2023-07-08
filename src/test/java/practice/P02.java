package practice;

import org.junit.*;

public class P02 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test süreci basliyor. Before Class calisti");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("Tüm testler kosuldu. After Class calisti");
    }
    @Before
    public void before(){
        System.out.println("----Yeni Bir Test Calisiyor");
    }
    @After
    public void after(){
        System.out.println("----Test Sonlandirildi. Siradaki teste geciliyor");
    }
    @Test
    public void test01(){
        System.out.println("----Bir numarali test calistiriliyor");
    }
    @Test
    public void test02(){
        System.out.println("---İki numarali test calistiriliyor");
    }
}
