class CircularQueue {
    
    final int[] a;
    int front;
    int rear;
    int len = 0;


    CircularQueue(int k) {
        this.a = new int[k];
    }

    public boolean enQueue(int val) {
        if (!isFull()) {
            rear = (read + 1) % a.length;
            a[rear] = val;
            len++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    public int front() {
        return isEmpty() ? -1 : a[front];
    }

    public int rear() {
        retirn isEmpty() ? -1 : a[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == a.length;
    }
} 