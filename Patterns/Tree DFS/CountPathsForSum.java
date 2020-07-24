import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class CountPathsForSum {
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathRecurrsively(root, S, currentPath);
    }

    private static int countPathRecurrsively(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }

        currentPath.add(currentNode.val);
        int pathCount = 0;
        int pathSum = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();

            if (pathSum == S) {
                pathCount++;
            }
        }

        pathCount += countPathRecurrsively(currentNode.left, S, currentPath);
        pathCount += countPathRecurrsively(currentNode.right, S, currentPath);
        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountPathsForSum.countPaths(root, 11));
    }
}