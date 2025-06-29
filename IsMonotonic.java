import java.util.*;
public class IsMonotonic{
    public static boolean isMontanic(ArrayList<Integer> A){
        boolean Inc=true;
        boolean Dec=true;
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i)>A.get(i+1)){
                Inc= false;
            }
            if(A.get(i)<A.get(i+1)){
                Dec=false;
            }
            
        }
        return Inc || Dec;
    }
    public static void main(String[]args){
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(2);
        System.out.println(isMontanic(A));
    }
}