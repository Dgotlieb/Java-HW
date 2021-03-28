import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    @Test
    public void test01_Cloud() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", "XXXXXXXXX");
        capabilities.setCapability("accessKey", "XXXXXXXXXXXXXXXX");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "83.0");
        capabilities.setCapability("build", "Onboarding Sample App - Java");
        capabilities.setCapability("name", "3-cross-browser");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com/wd/hub"), capabilities);
        driver.get("https://translate.google.com");
        driver.findElement(By.id("source")).sendKeys("hello");
        driver.quit();
    }

    @Test
    public void test02_Robot() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        robot.mouseMove((int)width,0);
        Thread.sleep(2000); // delay the click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(0,(int)height);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

// mvn -Dtest=<CLASS NAME>#<TEST NAME> test

}
