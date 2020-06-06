import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        //15
        int i, j;
        int n = 5;
        // outer loop to handle number of rows
        //  n in this case
        for(i=0; i<n; i++) {
            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for(j=0; j<=i; j++) {
                // printing stars
                System.out.print("* ");
            }
            // ending line after each row
            System.out.println();
        }

        //16
        int size = 7;
        char display = '#';
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col || row + col == size - 1) {
                    System.out.print(display);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //17
        // computeSum();

        //18
        Dog dog = new Dog();

        //19
        int number = 1;
        switch (number){
            case 1,2,3:
                System.out.println("A");
                break;
            case 4,5,6:
                System.out.println("B");
                break;
            case 7,8,9,10:
                System.out.println("C");
                break;
        }
    }

    //17
    static int getNumber(){
        System.out.println("Please enter a number");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static void computeSum(){
        int num = getNumber();
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        System.out.println(sum);
    }
}

