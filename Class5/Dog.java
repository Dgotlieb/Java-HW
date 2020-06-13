public class Dog {
    private String name;
    private int age;
    private boolean isHappy;

    public Dog(String name, int age, boolean isHappy) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }
}
