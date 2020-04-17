import java.util.Arrays;
import java.util.*;

class Threesum {
    public List<List<Integer>> calculate3Sum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> referenceSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> reference = new ArrayList<Integer>(Arrays.asList(nums[0], nums[1], nums[2]));
                sort(reference);
                result.add(reference);
                return result;
            } else {
                return result;
            }
        }
        
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        
        for (int a: nums) {
            if (visited.contains(nums[i])) {
                continue;
            } else {
                visited.add(nums[i]);
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    int b = entry.getKey();
                    // a + b + c = 0; c = 0 - a - b
                    int c = 0 - a - b;
                    if (!map.containsKey(c)) {
                        continue;
                    } 
                    else if (a == b || a == c) {
                        if (map.get(a) < 3) {
                            continue;
                        } else {
                            List<Integer> reference = new ArrayList<Integer>(Arrays.asList(a, b, 0 - a - b));
                            sort(reference);        
                            referenceSet.add(reference);
                        }
                    } else if (b == c) {
                        if (map.get(b) > 1) {
                            List<Integer> reference = new ArrayList<Integer>(Arrays.asList(a, b, 0 - a - b));
                            sort(reference);        
                            referenceSet.add(reference);   
                        }
                    } else {
                        List<Integer> reference = new ArrayList<Integer>(Arrays.asList(a, b, 0 - a - b));
                        sort(reference);        
                        referenceSet.add(reference);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(referenceSet);
    }

    private void sort(List<Integer> a) {
        if (a.get(0) >= a.get(1) && a.get(0) >= a.get(2)) {
            swap(a, 0, 2);
            if (a.get(0) >= a.get(1)) {
                swap(a, 0, 1);
            } 
        }

        if (a.get(1) >= a.get(0) && a.get(1) >= a.get(2)) {
            swap(a, 1, 2);
            if (a.get(0) >= a.get(1)) {
                swap(a, 0, 1);
            } 
        }

        if (a.get(2) >= a.get(0) && a.get(2) >= a.get(1)) {
            if (a.get(0) >= a.get(1)) {
                swap(a, 0, 1);
            } 
        }
    }

    private void swap(List<Integer> a, int i, int j) {
        Collections.swap(a, i, j);
    }

    public static void main(String[] args) {
        Threesum obj = new Threesum();
        int[] a =
        {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(obj.calculate3Sum(a));
    }
}