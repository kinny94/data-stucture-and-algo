class RecoverBinarySearchTree {
    class Solution {
    
        TreeNode preNode = null;
        TreeNode first = null;
        TreeNode second = null;
        
        public void recoverTree(TreeNode root) {
            helper(root);
            if (first != null && second != null) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }
        
        // inorder traversal
        private void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root.left);
            if (preNode != null && preNode.val > root.val) {
                if (first == null) {
                    first = preNode;
                    second = root;
                } else {
                    second = root;
                }
            } 
            preNode = root;
            helper(root.right);
        }
    }
}