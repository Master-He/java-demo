import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hewenji
 * @Date 2023/3/27 11:40
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime dateTime = LocalDateTime.of(2023, Month.MARCH, 25, 20, 30, 0);
        System.out.println(dateTime);

        System.out.println(System.currentTimeMillis());
        Instant now1 = Instant.now();
        System.out.println(now1.getEpochSecond());
        System.out.println(now1.getNano());
        System.out.println(now1.toEpochMilli());

        String a = "123";
        Map<String, String> map = new HashMap<>();
    }
}
