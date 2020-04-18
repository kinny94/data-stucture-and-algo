class DuplicatesInArray {

    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }  
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        DuplicatesInArray da = new DuplicatesInArray();
        da.containsDuplicate(a);
    }
}