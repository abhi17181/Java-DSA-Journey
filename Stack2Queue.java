import java.util.*;
public class QueueD {
    static class Stack {
        static Queue<Integer> s=new LinkedList<>();
        static Queue<Integer> s1=new LinkedList<>();
        public static boolean isEmpty(){
            return s.isEmpty() && s1.isEmpty();
        }
        public static void push(int data){
            if(!s.isEmpty()){
                s.add(data);
            }else{
                s1.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top=-1;
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    top=s.remove();
                    if(s.isEmpty()){
                        break; 
                    }
                    s1.add(top);
                }
            }else{
                while(!s1.isEmpty()){
                    top=s1.remove();
                    if(s1.isEmpty()){
                        break;
                    }
                    s.add(top);
                }
            }
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int top=-1;
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    top=s.remove();
                    s1.add(top);
                }
            }else{
                while(!s1.isEmpty()){
                    top=s1.remove();
                    s.add(top);
                }
            }
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s2=new Stack();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        while(!s2.isEmpty()){
            System.out.println(s2.peek());
            s2.pop();
        }
    }
}
