/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 /*
    you can also do it by first calculating the sun and num in a different function and then calling the maximum avgsubtree function recurrsively on left and right node but that'll be O(N^2)
 */
class NumSum {
    int num;
    Double sum;
    
    NumSum(int num, double sum) {
        this.num = num;
        this.sum = sum;
    }
}

class MaximumAverageSubtree {
    double result;
    public double maximumAverageSubtree(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }
    
    public NumSum helper(TreeNode node) {
        if (node == null) return new NumSum(0, 0);
        int sum = node.val;
        int num = 1;
        NumSum left = helper(node.left);
        NumSum right = helper(node.right);
        num += left.num + right.num;
        sum += left.sum + right.sum;
        result = Math.max(result, (double)sum/(double)num);
        return new NumSum(num, sum);
    }
}