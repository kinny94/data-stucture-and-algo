import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class MinimumDepthOfABinaryTree {
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftDepth = node.left != null ? minDepth(node.left) : Integer.MAX_VALUE;
        int rightDepth = node.right != null ? minDepth(node.right) : Integer.MAX_VALUE;

        return 1 + Math.min(leftDepth, rightDepth);
    }
}