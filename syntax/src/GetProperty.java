import javax.sound.midi.SysexMessage;
import java.util.Map;

public class GetProperty {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperties());

        String env = System.getenv().toString();
        System.out.println(env);

        String[] every_env = env.split(",");
        for (int i = 0; i < every_env.length; i++) {
            System.out.println(every_env[i]);
        }
    }
}
