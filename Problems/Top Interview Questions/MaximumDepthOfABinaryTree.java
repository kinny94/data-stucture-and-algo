class MaximumDepthOfABinaryTree {
    public int maxDepth(TreeNode root) {
        return root == null ? Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}