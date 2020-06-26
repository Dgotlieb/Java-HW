import java.util.Date;

//5
public class Utils {
    public static String getOS() {
        return System.getProperty("os.name");
    }

    public static String getCurrentDate() {
        return String.valueOf(new Date());
    }
}
