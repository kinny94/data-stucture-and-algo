class StackUsingQueueClass{
    class StackUsingQueue{
        Queue<Integer> queue1 = new ArrayDeque<Integer>(); 
        Queue<Integer> queue2 = new ArrayDeque<Integer>(); 
        
        void push(int data) {
            queue1.add(data);
        }
        
        boolean isEmpty() {
            return queue1.size() + queue2.size() == 0;
        }
        
        void swap_queues() {
            Queue<Integer> queue3 = queue1;
            queue1 = queue2;
            queue2 = queue3;
        }
        
        int pop() {
            if(isEmpty()) {
                return -1;
            }
            
            while(queue1.size() > 1){
                queue2.add(queue1.remove());
            }
            
            int value = queue1.remove();
            swap_queues();
            return value;
        }
    }
    
    public static void main(String[] args) {
        StackUsingQueueClass sqc = new StackUsingQueueClass();
        StackUsingQueueClass.StackUsingQueue sq = sqc.new StackUsingQueue();
        System.out.println("Pop(): " + sq.pop());
        sq.push(3);
        sq.push(5);
        sq.push(9);
        System.out.println("Pop(): " + sq.pop());
        sq.push(10);
        sq.push(16);
        System.out.println("Pop(): " + sq.pop());
    }    
}  