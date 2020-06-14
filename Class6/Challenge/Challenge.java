import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Challenge {
    public static void main(String[] args) throws IOException {
        //5
        readFromCSV();

        //6
        String fileName = "/xyz/test.txt";
        String messageToWrite = "My string";
        Files.writeString(Paths.get(fileName), messageToWrite, StandardCharsets.ISO_8859_1);

        //8
        archiveFile("C:\\Users\\dgotl\\Desktop\\Challenge.java");

        //9
        getWebsite();
    }

    private static void archiveFile(String fileToArchive) throws IOException {
        File f = new File("C:\\Users\\dgotl\\Desktop\\Challenge.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry(fileToArchive);
        out.putNextEntry(e);
        out.closeEntry();
        out.close();
    }

    private static void getWebsite(){
        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL("https://www.google.com").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        System.out.println(content);
    }

    private static void readFromCSV() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\dgotl\\Downloads\\Players.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            // use comma as separator
            String[] data = row.split(",");
            System.out.println(data[0] + " , " + data[1]);

        }
        csvReader.close();
    }
}

