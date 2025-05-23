public class lastOccurrence {
    public static int lastOccurrence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccurrence(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String[]args){
        int arr[]={2,4,5,6,7,3,55,7,3,2};
        System.out.println(lastOccurrence(arr,3,0));
    }
}
