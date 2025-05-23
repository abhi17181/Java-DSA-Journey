public class optimizedPower {
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        //int xm1=power(x,n-1);
        //int xn=x*xm1;
        //return xn;
        return x* power(x,n-1);
    }
    public static int OptimizedPower(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPowerSq=OptimizedPower(x,n/2)* OptimizedPower(x,n/2);
        if(n%2!=0){
            halfPowerSq=x*halfPowerSq;
        }
        return halfPowerSq;
    }
        public static void main(String[] args) {
        System.out.println(OptimizedPower(2,10));        
    }
}
