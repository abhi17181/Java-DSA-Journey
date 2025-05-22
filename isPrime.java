import java.util.*;
public class isPrime {
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=n;i++){
            if(n%i==0){
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }
    
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        if(isPrime(num)){
            System.out.println(num);
        }else{
        System.out.println(num);
        }
    }
}
