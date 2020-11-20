import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
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

    //3
    @Test
    public void Test05_alert() {
        driver.navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.findElement(By.id("MyAlert")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void Test06_prompt() {
        driver.findElement(By.id("MyPrompt")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Daniel");
        prompt.accept();
        String output = "Daniel";
        assertEquals(output, driver.findElement(By.id("output")).getText());
    }

    @Test
    public void Test07_confirmBox() {
        driver.findElement(By.id("MyConfirm")).click();
        Alert confirmbox = driver.switchTo().alert();
        confirmbox.accept();
        String output = "Confirmed";
        assertEquals(output, driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("MyConfirm")).click();
        confirmbox.dismiss();
        output = "canceled";
        assertEquals(output, driver.findElement(By.id("output")).getText());
    }

    @Test
    public void Test08_iFrame() {
        WebElement iFrameElement = driver.findElement(By.cssSelector("iframe[src='newFrame.html']"));
        driver.switchTo().frame(iFrameElement);
        System.out.println("IFrame text is:" + driver.findElement(By.id("iframe_container")).getText());
        driver.switchTo().defaultContent();
        assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

    @Test
    public void Test09_HandlingTabs() {
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.id("openNewTab")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));

        System.out.println("Tab text is: " + driver.findElement(By.id("new_tab_container")).getText());
        String output = "This is a new Tab";
        assertEquals(output, driver.findElement(By.id("new_tab_container")).getText());
        driver.close();
        driver.switchTo().window(oldTab);
        assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

    @Test
    public void Test10_windows() {
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.cssSelector("a[href='newWindow.html']")).click();
        for (String winHandle : driver.getWindowHandles()) { //Switch to new window opened
            driver.switchTo().window(winHandle);
        }
        System.out.println("Tab text is: " + driver.findElement(By.id("new_window_container")).getText());
        String output = "This is a new Window";
        assertEquals(output, driver.findElement(By.id("new_window_container")).getText());
        driver.close();
        driver.switchTo().window(winHandleBefore);
        assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

    //4
    // the pageLoadTimeout limits the time that the script allots for a web page to be displayed

    //5 + 6
    @Test
    public void Test11_use_utils() {
        System.out.println(Utils.getCurrentDate());
        System.out.println(Utils.getOS());
    }

    //7
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
