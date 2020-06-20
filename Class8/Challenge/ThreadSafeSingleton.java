import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    //synchronized method to control simultaneous access
    synchronized public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }

    public void writeToFile(String content) throws IOException {
        String filePath = "C:\\Users\\user\\log.txt";
        Files.writeString(Path.of(filePath), content + "\n", StandardOpenOption.APPEND);
    }
}
