class Solution {
    public int[] maxSlidingWindow(int[] arr, int windowSize) {
        if (arr == null || windowSize <= 0) {
            return new int[0];
        } 
        
        int[] result = new int[arr.length - windowSize + 1];
        int index = 0;
        
        Deque<Integer> dequeue = new ArrayDeque<>();
        
        for (int i=0; i<arr.length; i++) {
            while (!dequeue.isEmpty() && dequeue.peek() < i - windowSize + 1) {
                dequeue.poll();
            }
            
            while (!dequeue.isEmpty() && arr[dequeue.peekLast()] < arr[i]) {
                dequeue.pollLast();
            }
            
            dequeue.offer(i);
            if (i >= windowSize - 1) {
                result[index++] = arr[dequeue.peek()];
            }
        }
        
        return result;
    }
}