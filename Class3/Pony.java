package exrcesises.third;

//4
public class Pony extends Horse {
    public Pony(String name) {
        super(name);
    }

    public Pony(String name, int age) {
        super(name, age);
    }

    public void bite(){
        System.out.println("yamm");
    }
}
