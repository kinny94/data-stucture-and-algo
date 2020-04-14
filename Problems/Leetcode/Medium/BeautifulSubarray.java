public class BeautifulSubarray {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int k1 = 2;
        int[] nums2 = {2,5,4,9};
        int k2 = 2;
        System.out.println(numOfBeautifulSubArrays(nums1, k1));
        System.out.println(numOfBeautifulSubArrays(nums2, k2));
    }
    
    private static int numOfBeautifulSubArrays(int[] nums, int k) {
        int cnt = 0;
        int l = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1)
                cnt++;
            while (cnt > k) {
                if (nums[l++] % 2 == 1)
                    cnt--;
            }
            if (cnt == k) {
                res++;
            }
        }
        while (cnt == k) {
            if (nums[l++] % 2 == 1) {
                --cnt;
                if(cnt != k)
                    break;
            }
            res++;
        }
        return k == 1 ? res/2 : res;
    }
}