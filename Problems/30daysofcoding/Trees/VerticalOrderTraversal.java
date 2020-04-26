import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class VerticalOrderTraversal {
    class Node {
        TreeNode root;
        int hd;
        int vd;
        public Node(TreeNode root, int hd, int vd) {
            this.root = root;
            this.hd = hd;
            this.vd = vd;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0, 0));
        int minHd = 0;
        int maxHd = 0;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            map.putIfAbsent(cur.hd, new ArrayList<>());
            minHd = Math.min(minHd, cur.hd);
            maxHd = Math.max(maxHd, cur.hd);
            
            map.get(cur.hd).add(cur);
            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.hd - 1, cur.vd - 1));
            }
            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.hd + 1, cur.vd - 1));
            }
        }
        
        int index = 0;
        for (int i = minHd; i <= maxHd; i++) {

            Collections.sort(map.get(i), (a, b) -> {
                if (a.vd == b.vd) {
                    return a.root.val - b.root.val;
                } else {
                    return b.vd - a.vd;
                }
            });
            //res.add(map.get(i));
            res.add(new ArrayList<>());
            for (Node node : map.get(i)) {
                res.get(index).add(node.root.val);
            }
            index++;
        }
        
        return res;
    }
}