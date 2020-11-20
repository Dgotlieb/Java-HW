import exrcesises.class11.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class Challenge {
    private static WebDriver driver;

    @BeforeClass
    public static void setUP(){
        driver = DriverSingleton.getDriverInstance();
    }

    @Test
    public void test01_theMarker() throws InterruptedException {
        driver.get("https://www.themarker.com/");
        Thread.sleep(3000); // make sure (some) of the page loaded
        String in = driver.getPageSource();
        int i = 0;
        Pattern p = Pattern.compile("news");
        Matcher m = p.matcher(in);
        while (m.find()) {
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void test01_JSExecutor(){
        ((JavascriptExecutor)driver).executeScript("window.print();");
    }

    @Test
    public void test03_noNG(){
        driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
        WebElement firstname = driver.findElement(By.className("ng-pristine"));
        firstname.clear();
        firstname.sendKeys("Daniel");
        assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"), "Daniel");
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }
}
