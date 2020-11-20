import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

//4 + 5
public class Report {
    private static ChromeDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static void beforeClass() throws FileNotFoundException {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\dgotl\\IdeaProjects\\JavaHomeWorkSolutions\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Company", "Experts");
        // log results
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        test.log(Status.PASS, "Driver established successfully");

        ///////////////////////////////// 5 /////////////////////////////////
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        /////////////////////////////////////////////////////////////////////
    }


    @Test
    public void test2_clickTextField() throws IOException {
        driver.get("https://translate.google.com/");
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        driver.findElement(By.id("source")).click();
        test.log(Status.PASS, "Translate box click");
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "Test is done");
        driver.quit();
        // build and flush report
        extent.flush();
    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
