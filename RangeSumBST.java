import java.util.*;

class Solution {

    static class Node {
        int val;
        Node left, right;
    }

    // Create a new node
    static Node newNode(int item) {
        Node temp = new Node();
        temp.val = item;
        temp.left = temp.right = null;
        return temp;
    }

    // Sum of nodes in range [low, high] using BFS
    static int rangeSumBST(Node root, int low, int high) {
        if (root == null) return 0;

        int sum = 0; // Avoid global static variable
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // Add current node's value if in range
            if (curr.val >= low && curr.val <= high)
                sum += curr.val;

            // Go left if there might be values in range
            if (curr.left != null && curr.val > low)
                q.add(curr.left);

            // Go right if there might be values in range
            if (curr.right != null && curr.val < high)
                q.add(curr.right);
        }

        return sum;
    }

    // Insert into BST
    static Node insert(Node node, int data) {
        if (node == null)
            return newNode(data);
        if (data <= node.val)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    // Main method
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 18);

        int L = 7, R = 15;
        System.out.print("Sum in range [" + L + ", " + R + "]: ");
        System.out.print(rangeSumBST(root, L, R)); // Output: 32
    }
}
