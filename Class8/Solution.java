import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Solution {
    public static void main(String[] args) {
        //1A
        StringBuilder strBuilder = new StringBuilder("H");
        strBuilder.append("e");
        strBuilder.append("l");
        strBuilder.append("l");
        strBuilder.append("o");
        System.out.println(strBuilder);

        //1B
        String[] words = {"hello", "world", "radar", "math", "kayak", "bank", "rotor"};
        for (int i = 0; i < words.length; i++) {
            StringBuilder temp = new StringBuilder(words[i]);
            if (words[i].equals(temp.reverse().toString())) {
                System.out.println(temp);
            }
        }

        //2
        String output = String.format("%s = %d", "joe", 35);
        System.out.println(output);
        System.out.printf("%s%d", "joe = ", 35);
        // losing static type safety which can lead to exceptions

        //3
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(".*[a]+.*")) {
                System.out.println(words[i] + " contains a");
            } else {
                System.out.println(words[i] + " does not contains a");
            }
        }

        //4
        User user = new User("daniel", "123", 10);
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(new File(".").getAbsolutePath() + "\\user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5
        // Generics allow us to customize a "generic" method or class to whatever type
        // we are working with.

        //6
        printAnyElement(1);
        printAnyElement("sdvs");
        printAnyElement(true);

        //7
        // calculate2() abuses YAGNI & DRY principals
        // superCalculate() abuses YAGNI principal

        //8
        String dictionary = "Dictionary";
        StringBuilder strBuilder2 = new StringBuilder(dictionary);
        int aIndex = strBuilder2.indexOf("a");
        strBuilder2.replace( aIndex, aIndex + 1, "x");
        System.out.println(strBuilder2.toString());

        //9
        Method[] allMethods = String.class.getDeclaredMethods();
        int totalPublicMethods = 0;
        for (Method method : allMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
                totalPublicMethods++;
            }
        }
        System.out.println("Count is: " + totalPublicMethods);
    }

    public static <E> void printAnyElement(E element) {
        System.out.println(element);
    }
}
