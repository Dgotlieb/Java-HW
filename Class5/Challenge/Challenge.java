import java.util.HashMap;
import java.util.Map;

public class Challenge {
    public static void main(String[] args) {
        //9
        int[] numbers = {11, 67, 41, 79, 55};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 67){
                System.out.println("67 exists");
            }
        }

        //10 - containsKey()
        Map<String, String> users = new HashMap<>();
        users.put("admin", "admin");
        System.out.println(users.containsKey("admin"));
    }
}
