import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node checkBST(ArrayList<Integer> inOrder,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid=si+(ei-si)/2;
        Node root=new Node(inOrder.get(mid));
        root.left=checkBST(inOrder,si,mid-1);
        root.right=checkBST(inOrder,mid+1,ei);
        return root;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void GetINOrder(Node root,ArrayList<Integer> inOrder){
        if(root==null){
            return;
        }
        GetINOrder(root.left,inOrder);
        inOrder.add(root.data);
        GetINOrder(root.right,inOrder);
    }
    public static Node BalBST(Node root){
        ArrayList<Integer> inOrder=new ArrayList<>();
        GetINOrder(root,inOrder);
        root=checkBST(inOrder,0,inOrder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(6);
        root.left=new Node(5);
        root.left.left.left=new Node(3);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);
        root=BalBST(root);
        preOrder(root);
    }
}
