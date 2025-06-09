

public class PrintDigit {
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void printDigit(int numbers){
        if(numbers==0){
            return;
        }
        int lastDigit=numbers%10;
        printDigit(numbers/10);
        System.out.print(digits[lastDigit]+" ");
    }
    public static void main(String[]args){
        printDigit(1234);
    }
}
