public class PrintOccurence{
    public static void printOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return ;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        printOccurence(arr,key,i+1);
    }
    public static void main(String []args){
        int arr[]={3,2,4,5,6,2,7,2,2};
        int key=2;
        printOccurence(arr,key,0);
        
    }
}