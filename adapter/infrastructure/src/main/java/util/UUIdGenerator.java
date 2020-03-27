package util;
import java.util.UUID;

public class UUIdGenerator {
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
