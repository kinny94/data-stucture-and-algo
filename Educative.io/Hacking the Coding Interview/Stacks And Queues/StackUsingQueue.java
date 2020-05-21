import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    
    Queue<Integer> queue;

    StackUsingQueue() {
        this.queue = new LinkedList();
    }

    public void push(int x) {
        queue.add(x);
        int s = queue.size();
        while (s > 1) {
            queue.add(queue.remove());
            s--;
        }       
    }

    public int pop() {
        return queue.remove();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int top() {
        return queue.peek();
    }
}