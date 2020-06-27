import com.example.JSUtils;
import exrcesises.class11.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        driver = DriverSingleton.getDriverInstance();
        driver.get("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //1
    @Test
    public void Test01_iFrame() {
        WebElement iFrameElement = driver.findElement(By.cssSelector("iframe[src='newFrame.html']"));
        driver.switchTo().frame(iFrameElement);
        System.out.println("IFrame text is: " + driver.findElement(By.id("iframe_container")).getText());
        driver.switchTo().defaultContent();
        Assert.assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

    //2
    @Test
    public void test02_dragAndDrop() {
        driver.navigate().to("https://dgotlieb.github.io/Actions/");
        WebElement locationElement = driver.findElement(By.id("drag1"));
        WebElement destinationElement = driver.findElement(By.id("div1"));
        File screenShotFile = destinationElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSUtils.JavascriptDragAndDrop(driver, locationElement, destinationElement);
    }

    @Test
    public void test03_doubleClick() {
        WebElement doubleClickElement =
                driver.findElement(By.xpath("//p[@ondblclick='doubleClickFunction()']"));
        Actions doubleClickAction = new Actions(driver);
        doubleClickAction.doubleClick(doubleClickElement);
        doubleClickAction.build().perform();

        String result = driver.findElement(By.id("demo")).getText();
        Assert.assertEquals("You double clicked", result);
    }

    @Test
    public void test04_mosueHover() {
        Actions hoverAction = new Actions(driver);
        WebElement firstHoverElement = driver.findElement(By.id("demo"));
        WebElement secondHoverElement = driver.findElement(By.id("close"));
        hoverAction.moveToElement(firstHoverElement)
                .moveToElement(secondHoverElement)
                .click()
                .build()
                .perform();
    }

    @Test
    public void test05_selectMultiple() {
        List<WebElement> elementsList = driver.findElements(By.name("kind"));
        Actions builder = new Actions(driver);
        builder.clickAndHold(elementsList.get(0)).clickAndHold(elementsList.get(2)).click();
        builder.build().perform();
    }

    @Test
    public void test06_uploadFile() {
        driver.findElement(By.name("pic")).sendKeys("1.txt");
    }

    @Test
    public void test07_scrollToElement() throws InterruptedException {
        WebElement element = driver.findElement(By.id("clickMe"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
    }

    @Test
    public void test08_scrollToLocation() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        Thread.sleep(4000); // this is here just to see the move after the scroll
    }

    //3
    @Test
    public void test09_XML() {
        driver.navigate().to(getData("URL"));
    }

    private static String getData (String keyName) {
        // todo change path to the XML file
        File configXmlFile = new File("C:\\Users\\...\\class12\\config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }
}
