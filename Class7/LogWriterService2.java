import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogWriterService2 implements exrcesises.class8.LogsWriteable {
    @Override
    public void writeLogs(String log) throws IOException {
        String filePath = "C:\\Users\\user\\log2.txt";
        Files.writeString(Path.of(filePath), log, StandardOpenOption.APPEND);
    }
}
