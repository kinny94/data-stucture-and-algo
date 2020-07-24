import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
};

class CountStructurallyUniqueBST {
    public int countTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int count = 0;
        for (int i=1; i<=n; i++) {
            int countLeftSubTrees = countTrees(i - 1);
            int countRightSubTrees = countTrees(n - i);
            count += (countLeftSubTrees * countRightSubTrees);
        }

        return count;
    }

    public static void main(String[] args) {
        CountStructurallyUniqueBST ct = new CountStructurallyUniqueBST();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}