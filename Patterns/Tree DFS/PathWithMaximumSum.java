class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class PathWithMaximumSum {

    private static int globalMaximumSum;
    
    public static int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumHelper(root);
        return globalMaximumSum;
    }    

    private static int findMaximumPathSumHelper(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int maxPathSumFromLeft = findMaximumPathSumHelper(currentNode.left);
        int maxPathSumFromRight = findMaximumPathSumHelper(currentNode.right);

        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        int localMaximimSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;
        globalMaximumSum  = Math.max(globalMaximumSum, localMaximimSum);
        return Math.max(maxPathSumFromLeft,  maxPathSumFromRight) + currentNode.val;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));
        
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));
        
        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));
    }
    
}