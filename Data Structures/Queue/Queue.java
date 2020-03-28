class Queue {
    
    private int[] queue;
    private int size;
    private int front;
    private int last;

    Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.last = -1;
    }

    public boolean isEmpty() {
        return this.last == -1;
    }

    public boolean isFull() {
        return this.last == this.size;  
    }

    public void enqueue(int item) {
        if (!this.isFull()) {
            this.queue[++last] = item;
        } else {
            System.out.println("Queueif is already full!");
        }
    }

    public int dequeue() {
        if (!this.isEmpty()) {
            int returnValue = this.queue[front];

           for (int i=0; i<=this.last; i++) {
               this.queue[i] = this.queue[i+1];
           }
           --last;
           return returnValue;
        } else {
            System.out.println("Queueif is already full!");
            return -1;
        }
    }

    public void displayQueue() {
        for(int i=front; i<=last; i++){
            System.out.print(queue[i] + " : ");
        }
        System.out.println();
    }

    public int getQueueFront() {
        return this.queue[front];
    }

    public int getQueueRear() {
        return this.queue[last];
    }

    public void clear(){
        for(int i=front; i<=last; i++){
            System.out.print(queue[i] + " : ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.displayQueue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.displayQueue();
        System.out.println(queue.getQueueFront());
        System.out.println(queue.getQueueRear());
    }
}