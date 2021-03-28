import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Challenge {
    private static AndroidDriver<MobileElement> driver;

    // 4
    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
        capabilities.setCapability("appActivity", "il.co.mintapp.buyme.activities.common.SplashScreen");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1_getSource() {
        driver.findElement(By.id("il.co.mintapp.buyme:id/profileTab")).click();
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    
    // 5 run.bat in a seperated file mvn clean
    
    // 6 mvn clean
}
