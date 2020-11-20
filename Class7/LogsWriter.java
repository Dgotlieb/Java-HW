import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogsWriter {
    private static exrcesises.class8.LogsWriter instance = null;

    private LogsWriter() {}

    public static exrcesises.class8.LogsWriter getInstance() {
        if (instance == null) {
            instance = new exrcesises.class8.LogsWriter();
        }
        return instance;
    }

    public void writeToFile(String content) throws IOException {
        String filePath = "C:\\Users\\user\\log.txt";
        Files.writeString(Path.of(filePath), content + "\n", StandardOpenOption.APPEND);
    }
}