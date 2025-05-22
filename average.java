import java.util.*;
public class average {
    public static double average(double a,double b,double c){
        return(a+b+c)/3;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number");
        double a=sc.nextDouble();
        System.out.println("Enter  the second number");
        double b=sc.nextDouble();
        System.out.println("Enter the Third Number");
        double c=sc.nextDouble();
        System.out.println("the average is" +average(a,b,c));
        }
    }

