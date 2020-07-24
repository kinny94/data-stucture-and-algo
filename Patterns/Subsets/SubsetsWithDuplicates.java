import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = 0;

        for (int i=0; i<nums.length; i++) {
            startIndex = 0;

            if (i>0 && nums[i] == nums[i-1]) {
                startIndex = endIndex + 1;
            }

            endIndex = subsets.size() - 1;

            for (int j=startIndex; j<=endIndex; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }

        return subsets;
    }    

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}