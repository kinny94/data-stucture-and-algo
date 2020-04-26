class SerializeDeserializeBST {

    private String splitter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(splitter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        int[] pos = new int[1];
        pos[0] = 0;
        return buildTree(data.split(splitter), pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(String[] nodes, int[] pos, int min, int max) {
        if (pos[0] == nodes.length) return null;
        
        int val = Integer.valueOf(nodes[pos[0]]);
        if (val < min || val > max) return null; // Go back if we are over the boundary
        TreeNode cur = new TreeNode(val);
        
        pos[0]++; // update current position
        cur.left = buildTree(nodes, pos, min, val);
        cur.right = buildTree(nodes, pos, val, max);
        return cur;
    }
}