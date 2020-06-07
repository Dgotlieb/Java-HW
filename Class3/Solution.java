package exrcesises.third;

public class Solution {
    public static void main(String[] args) {
        //1
        Horse horse = new Horse("Hercules", 10);
        System.out.println(horse.getName());

        //2
        // sam

        //3
        // Yes, josh will be printed
        // the result of setName is being ignored because we don;t change the object name.

        //4+5
        WhitePony whitePony = new WhitePony("whity", 3);
        whitePony.bite();
        System.out.println(whitePony.getPonyColor());

        //6
        // In Java multiple inheritance is not allowed
        // In other words, a class can only extends one other class only

        //7
        // Because Apple and Dog are not in the same package an import statement is required
        // FIX: Add import animals.Dog inside Apple class.

        //8
        // Dog and Apple are in a separate package.
        // The method bark is protected and can't be used outside the package (only in inheritance)
        // FIX: Make Apple class extend Dog - which makes no sense (: OR make bark public

        //9
        // Whaf - Puppy

        //10
        // Encapsulation in Java is a mechanism of wrapping the code and data
        // (variables)acting on the data (methods) together as a single unit.
        // In encapsulation, the variables of a class will be hidden from other classes,
        // and can be accessed only through the methods of their current class. Therefore,
        // it is also known as data hiding.
    }
}

