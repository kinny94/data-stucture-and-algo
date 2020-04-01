class Heap {

    private int[] heap;
    private int heapSize;
    private static final int CAPACITY = 10;
    
    public Heap() {
        this.heap = new int[CAPACITY];
    }

    public void insert(int item) {
        if (isHeapFull()) throw new RuntimeException("Heap is full");

        this.heap[heapSize] = item;
        heapSize = heapSize + 1;
        heapifyUp(heapSize - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index-1)/2; // 2i + 1;
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = heap[index];
        this.heap[index] = this.heap[parentIndex];
        this.heap[parentIndex] = temp;
    }

    private boolean isHeapFull() {
        return CAPACITY == this.heapSize;
    }

    private int getMax() {
        return this.heap[0];
    }

    // it returns the maximum  item  + removes it from the heap
    private int poll() {
        int max = this.getMax();

        swap(0, heapSize-1);
        this.heapSize--;
        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // max heap - so parent node is always larger than children
        int largestIndex = index;

        if (leftIndex < heapSize && this.heap[leftIndex] > this.heap[index]) {
            largestIndex = leftIndex;
        }

        if (rightIndex < heapSize && this.heap[rightIndex] > this.heap[largestIndex]) {
            largestIndex = rightIndex;
        }

        // for the last case of index[heapsize - 1], both if check will fail and index == largestIndex
        if (index != largestIndex) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }

    public void heapsort() {
        int size = this.heapSize;
        for (int i=0; i<size; i++) {
            int max = this.poll();
            System.out.print(max+ " ");
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(8);
        heap.insert(12);
        heap.insert(20);
        heap.insert(-2);
        heap.insert(0);
        heap.insert(1);
        heap.insert(321);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());

        heap.insert(10);
        heap.insert(8);
        heap.insert(12);
        heap.insert(20);
        heap.insert(-2);
        heap.insert(0);
        heap.insert(1);
        heap.insert(321);

        heap.heapsort();
    }
}