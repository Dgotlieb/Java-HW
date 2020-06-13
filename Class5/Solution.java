package exrcesises.class5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 1
        String[] names = {"Abraham", "Izak", "Jacob"};
        names[1] = "Noah";
        System.out.println(names[2]);

        //2
        Dog a = new Dog("rexi", 5, true);
        Dog b = new Dog("lassi", 7, false);
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(a);
        dogs.add(b);
        System.out.println(dogs.get(0).getAge());
        dogs.clear();
        System.out.println(dogs.size());

        //3
        ArrayList<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");

        for (int i = 0; i < words.size(); i++) {
            if (i == 1){
                System.out.println(words.get(i));
            }
        }

        //4
        int[] numbers = {11, 36, 41, 79, 55, 99};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Average is: " + sum / numbers.length);

        //5
        // hello

        //6
        Map <String, String> users = new HashMap<>();
        users.put("admin", "admin");
        users.put("root", "root");
        users.put("sudo", "sudo");
        System.out.println(users.values());

        //7
        System.out.println("Please enter between 1-4");
        int userChoice = new Scanner(System.in).nextInt();
        switch (userChoice){
            case 1:
                System.out.println(Seasons.SUMMER);
                break;
            case 2:
                System.out.println(Seasons.WINTER);
                break;
            case 3:
                System.out.println(Seasons.SPRING);
                break;
            case 4:
                System.out.println(Seasons.FALL);
                break;
        }

        //8
        // No! var can't be used as a method argument.
    }
}
