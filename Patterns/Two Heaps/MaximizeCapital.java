import java.util.PriorityQueue;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n , (a, b) -> profits[b] - profits[a]);

        for (int i=0; i<n; i++) {
            minCapitalHeap.offer(i);
        }

        int availableCapital = initialCapital;
        for (int i=0; i<numberOfProjects; i++) {
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            availableCapital += profits[maxProfitHeap.poll()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}

