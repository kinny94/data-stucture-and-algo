import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode node: lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;

        while (!queue.isEmpty()) {
            currentNode.next = new ListNode(queue.poll());
            currentNode = currentNode.next;
        }

        return dummy.next;
    }    
}