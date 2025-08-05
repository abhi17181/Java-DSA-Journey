import java.util.*;
public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",100);
        hm.put("Russia",150);
        hm.put("Australia",50);
        hm.put("Nepal",10);
        hm.put("Us",150);
        //Iterate
        Set<String> keys=hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("key="+k+ ",value="+hm.get(k));
        }
    }
}
