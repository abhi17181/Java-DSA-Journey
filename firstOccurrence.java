public class firstOccurrence {
    public static int FirstOccurrence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return (FirstOccurrence(arr,key,i+1));
    }
    public static void main(String[] args) {
        int arr[]={7,3,6,9,5,10,9,2,5};
        System.out.println(FirstOccurrence(arr,5,0));
    }
}
