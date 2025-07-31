public class AVLTreeShort {

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    static int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    static int balance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left, T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right, T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    static Node minNode(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else if (key > root.data) root.right = insert(root.right, key);
        else return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bf = balance(root);

        if (bf > 1 && key < root.left.data) return rightRotate(root);
        if (bf < -1 && key > root.right.data) return leftRotate(root);
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) return root;

        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                Node temp = minNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        if (root == null) return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bf = balance(root);

        if (bf > 1 && balance(root.left) >= 0) return rightRotate(root);
        if (bf > 1 && balance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && balance(root.right) <= 0) return leftRotate(root);
        if (bf < -1 && balance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] vals = {10, 20, 30, 40, 50, 25};
        for (int v : vals)
            root = insert(root, v);

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();

        root = delete(root, 30);

        System.out.print("After deleting 30: ");
        inorder(root);
    }
}
