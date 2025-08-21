import java.util.*;
public class SetTypesComparison{
    public static void main(String[]args){
        HashSet<String> cities=new HashSet<>();
        cities.add("delhi");
        cities.add("mumbai");
        cities.add("Noida");
        cities.add("up");
        System.out.println(cities);

        LinkedHashSet<String> lhs=new  LinkedHashSet<>();
        lhs.add("delhi");
        lhs.add("mumbai");
        lhs.add("Noida");
        lhs.add("up");
        System.out.println(lhs);

        TreeSet<String> ts=new  TreeSet<>();
        ts.add("delhi");
        ts.add("mumbai");
        ts.add("noida");
        ts.add("up");
        System.out.println(ts);
    }
}
