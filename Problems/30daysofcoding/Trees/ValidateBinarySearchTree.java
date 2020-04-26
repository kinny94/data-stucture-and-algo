class ValidateBinarySearchTree {

    public boolean isValid(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer max, Integer min) {

        if (node == null) {
           return true;
        } else if (max != nul && node.val >= max || min != null && node.val <= min) {
            return false;
        } else {
            return helper(node.left, node.val, min) && helper(node.right, max, root.val);
        }
    }
}