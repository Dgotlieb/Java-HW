import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //10
        User user = new User("daniel");
        Method privateStringMethod = User.class.getDeclaredMethod("getName");
                privateStringMethod.setAccessible(true);
        String name = (String) privateStringMethod.invoke(user);
        System.out.println(name);

        //11
        String REGEX = "dog";
        String INPUT = "The dog says meow. All dogs say meow.";
        String REPLACE = "cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}
