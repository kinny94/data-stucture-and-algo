import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class UniqueBinarySearchTree {
    public static List<TreeNode> findUniqueTree(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        return findUniqueTreeHelper(1, n);
    }    

    public static List<TreeNode> findUniqueTreeHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i=start; i<=end; i++) {
            List<TreeNode> leftSubTrees = findUniqueTreeHelper(start, i-1);
            List<TreeNode> rightSubTrees = findUniqueTreeHelper(i+1, end);

            for (TreeNode leftTree: leftSubTrees) {
                for (TreeNode rightTree: rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }

        return result;
    }

    // DP method
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
         for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
         }
 
         return dp[n];
     } 

    public static void main(String[] args) {
        List<TreeNode> result = UniqueBinarySearchTree.findUniqueTree(2);
        System.out.print("Total trees: " + result.size());
    }
}