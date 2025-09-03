public class Solution {
    private static class Node {
        private char data;
        private String word;
        private boolean isEnd;
        private Node[] children;

        public Node(char data) {
            this.data = data;
            this.word = null;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

    private Node root = new Node('/');
    private String ans = "";

    // Insert word into Trie
    private void insert(String word) {
        Node curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node(word.charAt(i));
            }
            curr = curr.children[childIdx];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    // DFS to find longest word
    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        if (node.word != null) {
            if (node.word.length() > ans.length()) {
                ans = node.word;
            } else if (node.word.length() == ans.length() && node.word.compareTo(ans) < 0) {
                ans = node.word;
            }
        }
        for (Node child : node.children) {
            if (child != null && child.word != null) {
                dfs(child);
            }
        }
    }

    // Main function
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        dfs(this.root);
        return ans;
    }

    // ✅ Entry point
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"w","wo","wor","worl","world","banana","ban","bana","banan"};
        String result = sol.longestWord(words);
        System.out.println("Longest word: " + result);
    }
}
