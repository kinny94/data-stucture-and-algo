class PalindromPermutation {

    public boolean isPermutationOfPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        int oddNum = 0;
        for (int count : counts) {
            if (count % 2 == 1) {
                oddNum++;
            }
            if (oddNum > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromPermutation obj = new PalindromPermutation();
        System.out.println(obj.isPermutationOfPalindrome("Tact Coa"));
    }
} 