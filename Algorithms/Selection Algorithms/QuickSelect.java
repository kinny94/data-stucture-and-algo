import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

class QuickSelect {

    private int[] nums;

    QuickSelect(int[] nums) {
        this.nums = nums;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int select(int k) {
        return select(0, nums.length-1, k-1);
    }

    private int select(int firstIndex, int lastIndex, int k) {
        int pivot = partition(firstIndex, lastIndex);

        if (pivot > k) {
            return select(firstIndex, pivot-1, k);
        } else  if (pivot < k) {
            return select(pivot+1, lastIndex, k);
        }

        return nums[k];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex-firstIndex+1) + firstIndex;

        swap(lastIndex, pivot);

        for (int i=firstIndex; i<lastIndex; i++) {
            if (nums[i] > nums[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        swap(firstIndex, lastIndex);
        return firstIndex;
    }

    private int withPriorityQueue(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0;i<nums.length; i++) {
            pq.add(nums[i]);
        }

        int x = 0;
        int result = 0;
        while(x != k) {
            x++;
            if (x == k) {
                result = pq.poll();
                return result;
            }
            pq.poll();  
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 8, -2};
        QuickSelect qs = new QuickSelect(nums);
        System.out.println(qs.select(2));
        System.out.println(qs.withPriorityQueue(2));

    }
}
