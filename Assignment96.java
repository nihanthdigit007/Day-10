import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Assignment96 {
    private final Map<String, String> map = new ConcurrentHashMap<>();
    public synchronized void put(String key, String value) {
        map.put(key, value);
    }
    public synchronized String get(String key) {
        return map.get(key);
    }
    public synchronized void remove(String key) {
        map.remove(key);
    }
    public static void main(String[] args) {
        Assignment96 demo = new Assignment96();
        demo.put("1", "One");
        demo.put("2", "Two");

        System.out.println("Key 1: " + demo.get("1"));
        System.out.println("Key 2: " + demo.get("2"));

        demo.remove("1");
        System.out.println("Key 1 after removal: " + demo.get("1"));
    }
}
