import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> visisbleNodes = new ArrayLis<>();

        if (root == null) {
            return visisbleNodes;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode current = queue.remove();

                if (i == size  - 1) {
                    visisbleNodes.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
 
                if (current.right != null) {
                    queue.add(current.right);
                }
                
            }
        }

        return visisbleNodes;
    }
}