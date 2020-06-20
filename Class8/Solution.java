import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException, ExecutionControl.NotImplementedException {
        //1
        //JavaBeans are classes that encapsulate many objects into a single object (the bean).

        //2
        // No, they are not.
        // They should fit many languages in general.

        //3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        LogsWriter.getInstance().writeToFile(scanner.next());
        System.out.println("Please enter your age");
        LogsWriter.getInstance().writeToFile(scanner.next());
        System.out.println("Please enter your address");
        LogsWriter.getInstance().writeToFile(scanner.next());
        System.out.println("Please enter your phone number");
        LogsWriter.getInstance().writeToFile(scanner.next());
        System.out.println("Thanks");


        //4
        LogWriterService1 service1 = new LogWriterService1();
        FirstLogger firstLogger = new FirstLogger(service1);
        firstLogger.write("hello");

        //5
        Drivable car = CarFactory.getCar("BMW");
        car.drive();

        //6
        // Inside BidTest.java

    }
}
