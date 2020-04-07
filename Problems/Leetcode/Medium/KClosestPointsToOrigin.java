/**
 * Instead, we can maintain a max-heap with size K. Then for each point, we add it to the heap. Once the size of the heap is greater than K, we are supposed to extract one from the max heap to ensure the size of the heap is always K. Thus, the max heap is always maintain top K smallest elements from the first one to crruent one. Once the size of the heap is over its maximum capacity, it will exclude the maximum element in it, since it can not be the proper candidate anymore.
 */
class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}