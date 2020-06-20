import java.io.IOException;

public class FirstLogger implements Logger {
    private exrcesises.class8.LogsWriteable logsWriteable;

    public FirstLogger(exrcesises.class8.LogsWriteable logsWriteable){
        this.logsWriteable = logsWriteable;
    }

    @Override
    public void write(String log) throws IOException {
        logsWriteable.writeLogs(log);
    }
}
