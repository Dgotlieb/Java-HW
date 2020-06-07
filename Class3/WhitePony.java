package exrcesises.third;

//5
public class WhitePony extends Pony {
    public WhitePony(String name) {
        super(name);
    }

    public WhitePony(String name, int age) {
        super(name, age);
    }

    public String getPonyColor(){
        return "white";
    }
}
