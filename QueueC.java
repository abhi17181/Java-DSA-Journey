import java.util.*;
public class QueueC {
    static class Queue{
        static Stack<Integer> q1=new Stack<>();
        static Stack<Integer> q2=new Stack<>();
        public static boolean isEmpty(){
            return q1.isEmpty();
        }
        public static void add(int data){
            while(!q1.isEmpty()){
                q2.push(q1.pop());
            }
            q1.push(data);
            while(!q2.isEmpty()){
                q1.push(q2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return q1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return q1.peek();
        }
    }
    public static void main(String[]args){
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
