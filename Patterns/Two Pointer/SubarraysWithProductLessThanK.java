import java.util.ArrayList;
import java.util.List;

class SubarraysWithProductLessThanK {
    
    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        
        List<List<Integer>> results = new ArrayList<>();
        int product = 1;
        int left = 0;

        for (int right=0; right<arr.length; right++) {
            product  = product * arr[right];
            while (product >= target && left < arr.length) {
                product = product / arr[left];
                left++;
            }

            List<Integer> tempList = new ArrayList<>();
            for (int i=right; i >= left; i--) {
                tempList.add(0, arr[i]);
                results.add(new ArrayList<>(tempList));
            }
        }

        return results;
    }

    public static void main(String[] args) {
        SubarraysWithProductLessThanK obj = new SubarraysWithProductLessThanK();
        System.out.println(obj.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(obj.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}