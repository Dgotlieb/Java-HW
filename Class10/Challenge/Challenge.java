import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Challenge {
    public static void main(String[] args) {
        //15
        ChromeDriver driver = new ChromeDriver();
        WebElement element = driver.findElement(By.id("hello"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        //16
        // Yes, Selenium Grid
    }
}
