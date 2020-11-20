import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Solution {
    private static ChromeDriver chromeDriver;
    private static FirefoxDriver firefoxDriver;

    @BeforeClass
    public static void beforeAll() {
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    //1
    @Test
    public void test01_open_websites() {
        chromeDriver.get("https://www.walla.co.il");
        firefoxDriver.get("https://www.ynet.co.il");
    }

    //2
    @Test
    public void test02_test_title() {
        String wallaTitle = "וואלה! NEWS - האתר המוביל בישראל - עדכונים מסביב לשעון";
        chromeDriver.navigate().refresh();
        Assert.assertEquals(chromeDriver.getTitle(), wallaTitle);
    }

    //3
    @Test
    public void test03_URL_assert() {
        String wallaURL = "https://www.walla.co.il/";
        Assert.assertEquals(chromeDriver.getCurrentUrl(), wallaURL);
    }

    //4
    @Test
    public void test04_google_translate() {
        chromeDriver.get("https://translate.google.com");
        System.out.println(chromeDriver.findElement(By.id("source")));
        System.out.println(chromeDriver.findElement(By.tagName("textarea")));
    }

    //5
    @Test
    public void test05_youtube() {
        firefoxDriver.get("https://www.youtube.com/");
        System.out.println(firefoxDriver.findElement(By.id("search-icon-legacy")));
    }

    //6
    @Test
    public void test06_seleniumHQ() {
        firefoxDriver.get("http://www.seleniumhq.org/");
        WebElement searchElement = firefoxDriver.findElement(By.name("search"));
        System.out.println(searchElement);
        searchElement.sendKeys("selenium");
    }

    //7
    @Test
    public void test07_amazon() {
        chromeDriver.get("http://www.amazon.com/");
        String amazonTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(chromeDriver.getTitle(), amazonTitle);
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
    }

    //8
    @Test
    public void test08_translate() {
        chromeDriver.get("https://translate.google.com");
        chromeDriver.findElement(By.id("source")).sendKeys("שלום");
    }

    //9
    @Test
    public void test09_find_song() {
        chromeDriver.get("https://www.youtube.com");
        chromeDriver.findElement(By.id("search")).sendKeys("November rain");
        chromeDriver.findElement(By.id("search-icon-legacy")).click();
    }

    //10
    @Test
    public void test10_controllers() {
        chromeDriver.get("https://dgotlieb.github.io/Controllers/");
        List<WebElement> list = chromeDriver.findElements(By.name("group1"));// exercise b
        for (WebElement tempElement : list) {
            if (tempElement.getAttribute("value").equals("Cheese")) {
                tempElement.click();
            }
            System.out.println(tempElement.getAttribute("value"));
        }
        Select selection = new Select(chromeDriver.findElement(By.name("dropdownmenu")));
        selection.selectByValue("Milk");
        for (int i = 0; i < selection.getOptions().size(); i++) {
            System.out.println(selection.getOptions().get(i).getText());
        }
    }

    //11
    @Test
    public void test11_facebook() {
        chromeDriver.get("https://www.facebook.com");
        chromeDriver.findElement(By.id("email")).sendKeys("admin");
        chromeDriver.findElement(By.id("pass")).sendKeys("admin");
    }

    //12
    @Test
    public void test12_web_calculator() {
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(chromeDriver.findElement(By.id("seven")).getSize());
        System.out.println(chromeDriver.findElement(By.id("six")).isDisplayed());

        chromeDriver.findElement(By.id("five")).click();
        chromeDriver.findElement(By.id("add")).click();
        chromeDriver.findElement(By.id("five")).click();
        chromeDriver.findElement(By.id("equal")).click();

        String res = chromeDriver.findElement(By.id("screen")).getText();
        String expectedResult = "10";
        Assert.assertEquals(expectedResult, res);
    }

    //13
    @Test
    public void test13_calculator_dimensions() {
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(chromeDriver.findElement(By.id("two")).getRect().getHeight());
        System.out.println(chromeDriver.findElement(By.id("six")).getRect().getWidth());
    }

    //14
    @Test
    public void test14_extensions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeDriver = new ChromeDriver(chromeOptions);
    }

    @AfterClass
    public void afterAll() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
