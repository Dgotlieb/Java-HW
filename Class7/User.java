import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String id;
    private transient int age;

    public User(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
