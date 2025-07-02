public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // Add at end for testing
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Recursive helper to search for key
    public int searchRecursive(Node head, int key) {
        if (head == null) return -1;
        if (head.data == key) return 0;

        int idx = searchRecursive(head.next, key);
        return (idx == -1) ? -1 : idx + 1;
    }

    public int search(int key) {
        return searchRecursive(head, key);
    }

    // Main for testing
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);

        int key = 30;
        int position = ll.search(key);
        System.out.println("Key " + key + " found at position: " + position); // Output: 2

        key = 50;
        position = ll.search(key);
        System.out.println("Key " + key + " found at position: " + position); // Output: -1
    }
}
