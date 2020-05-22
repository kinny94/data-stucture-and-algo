class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class FlattenABinaryTreeToLinkedList {
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
    }
}