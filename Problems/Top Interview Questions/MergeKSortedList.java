import java.util.PriorityQueue;

class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {

        if (list == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode node: lists) {
            while(node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(!queue.isEmpty()) {
            current.next = new ListNode(queue.remove());
            current = current.next;
        }

        return dummy.next;
    }
}