public class methodOverloading {
    public static void main(String[]args){
        Calculator calc=new Calculator();
        System.out.println(calc.sum(5,7));
        System.out.println(calc.sum((float)5.6,(float)6.4));
        System.out.println(calc.sum(5,7,8));
    }
}
class Calculator{
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
}
