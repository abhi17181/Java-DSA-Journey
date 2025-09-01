import java.util.*;

class TrieNode {
    List<String> data;
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        data = new ArrayList<>();
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Solution {
    static TrieNode root;
    List<List<String>> ans;

    public List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>();
        root = new TrieNode();
        for (String word : strs) build(word);
        dfs(root);
        return ans;
    }

    // Insert word into Trie based on sorted characters
    private void build(String s) {
        TrieNode temp = root;
        char[] word = s.toCharArray();
        Arrays.sort(word);
        for (char c : word) {
            int idx = c - 'a';
            if (temp.children[idx] == null) temp.children[idx] = new TrieNode();
            temp = temp.children[idx];
        }
        temp.isEnd = true;
        temp.data.add(s);
    }

    // DFS to collect all groups
    private void dfs(TrieNode node) {
        if (node.isEnd) ans.add(node.data);
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) dfs(node.children[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // sample input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = sol.groupAnagrams(strs);

        System.out.println(groups);
    }
}
