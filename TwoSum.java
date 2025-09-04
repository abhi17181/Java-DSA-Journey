import java.util.*;

class Solution2 {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if (visited.containsKey(diff)) {
                return new int[]{i, visited.get(diff)};
            }

            visited.put(arr[i], i);
        }
        return new int[]{0, 0}; // if no solution
    }

    public static void main(String[] args) {
        Solution2 obj = new Solution2();
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] res = obj.twoSum(arr, target);
        System.out.println("Indices: " + res[0] + ", " + res[1]);
    }
}
