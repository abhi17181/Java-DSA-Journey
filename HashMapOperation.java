import java.util.*;
public class HashMapOperation {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();

        //Put-O(1)
        hm.put("India",100);
        hm.put("Russia",150);
        hm.put("Australia",50);
        System.out.println(hm);

        //Get-O(1)
        System.out.println(hm.get("India"));

        //containsKey-O(1)
        System.out.println(hm.containsKey("Russia"));

        //remove-O(1)
        System.out.println(hm.remove("Australia"));
        System.out.println(hm);

        //size-O(1)
        System.out.println(hm.size());

        //isEmpty-O(1)
        System.out.println(hm.isEmpty());

    }
}
