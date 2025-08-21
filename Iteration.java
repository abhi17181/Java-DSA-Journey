import java.util.*;
public class Iteration{
    public static void main(String[]args){
        HashSet<String> cities=new HashSet<>();
        cities.add("delhi");
        cities.add("mumbai");
        cities.add("Noida");
        cities.add("up");
        // Iterator  it=cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        for(String city:cities){
            System.out.println(city);
        }
    }
}