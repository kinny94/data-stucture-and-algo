class LongestRepeatingSubstringString {
    private String S;
    // T = O(N*K), S = O(N), where N is length of S and K avg depth of trie.
    public String longestDupSubstring(String S) {
        this.S = S;
        int maxLo = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxLo = i;
            }
        }
        return S.substring(maxLo, maxLo + maxLength);
    }
    
    private boolean isLeaf(TrieNode node) {
        return node.next == null;
    }
    
    private int getIndex(int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }
    
    private int addNew(TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) return depth;
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }
    
    private static class TrieNode {
        private TrieNode[] next;
        private int i;
        private int depth;
        
        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        LongestRepeatingSubstringString obj = new LongestRepeatingSubstringString();
        System.out.println(obj.longestDupSubstring("tomorrow"));
    }
}