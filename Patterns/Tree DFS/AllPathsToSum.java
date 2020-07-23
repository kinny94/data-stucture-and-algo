import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class AllPathsToSum {
    public static List<List<Integer>> findPaths(TreeNode root, int sum)  {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathReccursively(root, sum, currentPath, result);
        return result;
    }

    private static void findPathReccursively(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode.val);

        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPathReccursively(currentNode.left, sum - currentNode.val, currentPath, result);
            findPathReccursively(currentNode.right, sum - currentNode.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    } 

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = AllPathsToSum.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}