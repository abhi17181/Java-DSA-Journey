import java.util.*;

public class KthLargestElementStream {

    static PriorityQueue<Integer> minHeap;
    static int k;

    static List<Integer> getAllKthLargest(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int val : arr) {
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else {
                if (val > minHeap.peek()) {
                    minHeap.poll();  // Remove smallest
                    minHeap.add(val);
                }
            }

            if (minHeap.size() >= k) {
                result.add(minHeap.peek());  // K-th largest
            } else {
                result.add(-1);  // Less than k elements seen so far
            }
        }
        return result;
    }

    public static void main(String[] args) {
        minHeap = new PriorityQueue<>(); // Min-heap
        k = 4;

        int[] arr = {1, 2, 3, 4, 5, 6};

        List<Integer> output = getAllKthLargest(arr);
        for (int val : output) {
            System.out.print(val + " ");
        }
    }
}
