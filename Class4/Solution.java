package exrcesises.fourth;

public class Solution extends MyAbstractClass implements Inter {
    public static void main(String[] args) {
        // 1A
        try {
            int a = 1 / 0;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        //1B
        // Yes

        //1C
        // All exception types

        //1D
        // It is too general and can can give less onformation than a specific one.
        // Also, it may indicate we don't actually know what can go wrong

        //2
        new Solution().doSomething();

        //3
        new Solution().doSomethingAbstract();

        //4
        // Compilation error - Abstract class can not be instantiated

        //6A
        Ball ball = new Ball();
        System.out.println(ball.isRound);

        //6B
        ball.isRound = false;

        //7
        // static modifier can't be used inside a method

        //8
        // because s was not initialized the code will throw a NullPointerException

        //9
        // Normally never, this is because GC is called automatically

        //10
        // D - All

        //11
        // Yes, when it makes no sense to continue
        // Example: we want to test a website but can't connect to internet

        //12
        // RuntimeException


    }

    @Override
    public void doSomething() {
        System.out.println("Something");
    }

    @Override
    void doSomethingAbstract() {
        System.out.println("Something abstract");
    }
}
