import java.util.*;
public class Solution{
    static class Queue{
        Deque<Integer> q=new LinkedList<>();
        public void add(int data){
            q.addLast(data);
        }
        public int remove(){
            return q.removeFirst();
        }
        public int peek(){
            return q.getFirst();  
        }
    }
    public static void main(String[]args){
        Queue qq=new Queue();
        qq.add(1);
        qq.add(2);
        qq.add(3);
        System.out.println("peek="+ qq.peek());
        System.out.println(qq.remove());
        System.out.println(qq.remove());
        System.out.println(qq.remove());
    }
}
