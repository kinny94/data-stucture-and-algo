import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class LeftViewOfASubTree {

    public List<Integer>  getLeftView(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();

        if (root == null) {
            return leftView;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {

                TreeNode current = queue.remove();
                if (i == size - 2) {
                    leftView.add(current.val);
                } 

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return leftView;
    }
}