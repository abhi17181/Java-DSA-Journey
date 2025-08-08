import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("India", 100);
        map.put("USA", 200);
        map.put("China", 300);

        System.out.println("LinkedHashMap: " + map);
        System.out.println("Value for India: " + map.get("India"));

        map.remove("USA");
        System.out.println("After removing USA: " + map);

        System.out.println("Contains China? " + map.containsKey("China"));
    }
}
