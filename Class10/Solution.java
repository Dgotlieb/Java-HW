import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Solution {
    private static WebDriver driver;
    private static NgWebDriver ngWebDriver;

    @BeforeClass
    public static void beforeAll() {
        driver = DriverSingleton.getDriverInstance();
        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //1
    @Test
    public void Test01_ImplicitWait() {
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("checkbox")).isDisplayed();
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.id("message")).isDisplayed();
    }

    @Test
    public void Test02_Sleep() throws InterruptedException {
        // Sleep
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("div[style='']")).isDisplayed();
    }

    @Test
    public void Test03_ExplicitWait() {
        // Explicit Wait
        driver.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        String output = driver.findElement(By.id("finish2")).getText();
        assertEquals(output, "This is a new element");
    }

    //2
    @Test
    public void Test04_angularTest() {
        driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
        ngWebDriver.waitForAngularRequestsToFinish();
        WebElement firstname = driver.findElement(ByAngular.model("firstName"));
        firstname.clear();
        firstname.sendKeys("Daniel");
        assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"), "Daniel");
    }

    //3 --> defines the amount of time that Selenium will wait for a page to load


    //4
    @Test
    public void Test12_POM() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/WebCalculator");
        System.out.println(driver.findElement(By.id(Constants.SEVEN)).getSize());
        System.out.println(driver.findElement(By.id("six")).isDisplayed());
        WebCalculatorPage.pressFive();
        WebCalculatorPage.pressPlus();
        WebCalculatorPage.pressFive();
        WebCalculatorPage.pressEquals();
        Thread.sleep(1000);
        String expectedResult = "10";
        assertEquals(expectedResult, WebCalculatorPage.getResult());
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }
}
