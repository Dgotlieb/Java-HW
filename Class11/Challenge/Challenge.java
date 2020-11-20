import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Challenge {
    private static WebDriver driver;
    private String jsonPath = "C:\\Users\\dgotl\\IdeaProjects\\JavaHomeWorkSolutions\\src\\main\\java\\challenges\\class12\\data.json";

    @BeforeClass
    public static void setUP(){
        driver = new ChromeDriver();
    }

    @Test
    public void test06_HandlingTabs() {
        driver.get("https://www.google.com");
        String googleTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.youtube.com','_blank');");
        String youtubeTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open('https://translate.google.com','_blank');");
        driver.switchTo().window(googleTab);
        driver.switchTo().window(youtubeTab);
    }

    //7
    @Test
    public void test07_JSON() throws IOException, ParseException {
       driver.get(getURLFromJSON());
    }

    //8
    @Test
    public void test08_gson() throws IOException, ParseException {
        Gson gson = new Gson();
        Config config = gson.fromJson(new FileReader(jsonPath), Config.class);
        driver.get(config.getURL());
    }

    private String getURLFromJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(new FileReader(jsonPath));
        String URL = (String) data.get("URL");

        return URL;
    }

    @AfterClass
    public void afterAll() {
         driver.quit();
    }
}
