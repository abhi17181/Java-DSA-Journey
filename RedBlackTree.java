import java.io.*;

public class RedBlackTree {

    public Node root;

    public RedBlackTree() {
        root = null;
    }

    class Node {
        int data;
        Node left, right, parent;
        char colour;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.colour = 'R';  // New node is always RED initially
            this.parent = null;
        }
    }

    // Rotation helpers
    Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;

        x.left = node;
        node.right = y;

        node.parent = x;
        if (y != null) y.parent = node;

        return x;
    }

    Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;

        x.right = node;
        node.left = y;

        node.parent = x;
        if (y != null) y.parent = node;

        return x;
    }

    // Flags for rotations
    boolean ll = false, rr = false, lr = false, rl = false;

    // Recursive insertion helper with balancing
    Node insertHelp(Node root, int data) {
        boolean f = false;

        if (root == null)
            return new Node(data);
        else if (data < root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;

            if (root != this.root && root.colour == 'R' && root.left.colour == 'R')
                f = true;
        } else {
            root.right = insertHelp(root.right, data);
            root.right.parent = root;

            if (root != this.root && root.colour == 'R' && root.right.colour == 'R')
                f = true;
        }

        // Handle rotations
        if (ll) {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            ll = false;
        } else if (rr) {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            rr = false;
        } else if (rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            rl = false;
        } else if (lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            lr = false;
        }

        // Handle red-red conflict
        if (f) {
            if (root.parent.right == root) {
                if (root.parent.left == null || root.parent.left.colour == 'B') {
                    if (root.left != null && root.left.colour == 'R') rl = true;
                    else if (root.right != null && root.right.colour == 'R') ll = true;
                } else {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if (root.parent != this.root)
                        root.parent.colour = 'R';
                }
            } else {
                if (root.parent.right == null || root.parent.right.colour == 'B') {
                    if (root.left != null && root.left.colour == 'R') rr = true;
                    else if (root.right != null && root.right.colour == 'R') lr = true;
                } else {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if (root.parent != this.root)
                        root.parent.colour = 'R';
                }
            }
            f = false;
        }

        return root;
    }

    // Public insert method
    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.colour = 'B';
        } else {
            this.root = insertHelp(this.root, data);
        }
    }

    // Inorder traversal
    void inorderTraversalHelper(Node node) {
        if (node != null) {
            inorderTraversalHelper(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalHelper(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
    }

    // Pretty print the tree
    void printTreeHelper(Node root, int space) {
        if (root != null) {
            space += 10;
            printTreeHelper(root.right, space);
            System.out.printf("\n");
            for (int i = 10; i < space; i++) System.out.print(" ");
            System.out.printf("%d(%c)\n", root.data, root.colour);
            printTreeHelper(root.left, space);
        }
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
    }

    // Main method
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        int[] arr = {1, 4, 6, 3, 5, 7, 8, 2, 9};

        for (int i = 0; i < arr.length; i++) {
            t.insert(arr[i]);
            System.out.println("Inorder after inserting " + arr[i] + ":");
            t.inorderTraversal();
            System.out.println("\n");
        }

        System.out.println("Final Tree Structure:");
        t.printTree();
    }
}
