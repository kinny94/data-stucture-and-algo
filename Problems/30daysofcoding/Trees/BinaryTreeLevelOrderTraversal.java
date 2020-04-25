import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode node) {

        List<List<Integer>> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> currentLevel = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}