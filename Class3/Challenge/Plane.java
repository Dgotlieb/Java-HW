package challenges.third;

public class Plane implements Movable{
    @Override
    public void go() {
        System.out.println("Fly");
    }

    @Override
    public void stop() {
        System.out.println("Wheels down");
    }
}
