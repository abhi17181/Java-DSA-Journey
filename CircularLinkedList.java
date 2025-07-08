class Solution {
    static class Node {
        int data;
        Node next;
    }

    // 1. Add to empty list
    static Node addToEmpty(Node last, int data) {
        if (last != null) return last;

        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        newNode.next = last; // Circular
        return last;
    }

    // 2. Add at front (after last)
    static Node addFront(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    // 3. Add at end (after last, update last)
    static Node addEnd(Node last, int data) {
        if (last == null) return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // 4. Add after a specific node
    static Node addAfter(Node last, int data, int item) {
        if (last == null) return null;

        Node newNode, p;
        p = last.next;

        do {
            if (p.data == item) {
                newNode = new Node();
                newNode.data = data;
                newNode.next = p.next;
                p.next = newNode;

                if (p == last)
                    last = newNode;

                return last;
            }
            p = p.next;
        } while (p != last.next);

        System.out.println(item + " not found in the list.");
        return last;
    }

    // 5. Delete a node
    static Node deleteNode(Node last, int key) {
        if (last == null) return null;

        // If list has only one node
        if (last.data == key && last.next == last) {
            return null;
        }

        Node temp = last, d;

        // If node to delete is the last
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            return last;
        }

        // Search for the node to delete
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        // If node found
        if (temp.next.data == key) {
            d = temp.next;
            temp.next = d.next;
        }

        return last;
    }

    // 6. Traverse the list
    static void traverse(Node last) {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Node last = null;

        last = addToEmpty(last, 6);
        last = addEnd(last, 8);         
        last = addFront(last, 2);       
        last = addAfter(last, 10, 2);

        traverse(last);             
        last = deleteNode(last, 8);     
        traverse(last);                 
    }
}
