import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    
    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
    
    public void printTree() {
        TreeNode current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

class ConnectAllLevelOrderSiblings {
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;
        TreeNode previous = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (previous != null) {
                previous.next = current;
            }

            previous = current;

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllLevelOrderSiblings.connect(root);
        root.printTree();
    }
}