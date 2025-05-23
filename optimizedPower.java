public class optimizedPower {
    public static int OptimizedPower(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPower=OptimizedPower(x,n/2);
        int halfPowerSq=halfPower * halfPower ;
        if(n%2!=0){
            halfPowerSq=x*halfPowerSq;
        }
        return halfPowerSq;
    }
        public static void main(String[] args) {
        System.out.println(OptimizedPower(2,10));        
    }
}
