import java.io.*;
import java.util.*;

class Solution {

    // Function to find minimum time to reach all positions from initial K positions
    public static void minTime(int arr[], int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N + 1];  // 1-based indexing
        int time = 0;

        // Add initial positions to queue and mark them as visited
        for (int i = 0; i < K; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }

        // BFS-style level-order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                // Spread to left
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }

                // Spread to right
                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }

        // Since time increments even after final step, subtract 1
        System.out.println(time - 1);
    }

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 6 };
        int K = arr.length;

        minTime(arr, N, K);  // Output: 2
    }
}
