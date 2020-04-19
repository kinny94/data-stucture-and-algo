class CheckPermutation {
    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for (int i=0; i<str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i=0; i<str2.length(); i++) {
            letters[str2.charAt(i)]--;
        }

        for (int i=0; i<letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation();
        System.out.println(cp.checkPermutation("hello", "olleh"));

    }
}