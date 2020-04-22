import java.util.*;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        addSubsets(result, 0, new ArrayList<Integer>(), nums);
        return result;
    }
    
    public void addSubsets(List<List<Integer>> result, int index, List<Integer> current, int[] nums) {
        
        result.add(new ArrayList<>(current));
        for (int i=index; i<nums.length; i++) {
            current.add(nums[i]);
            addSubsets(result,i + 1,current, nums);
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(a));
    }
}