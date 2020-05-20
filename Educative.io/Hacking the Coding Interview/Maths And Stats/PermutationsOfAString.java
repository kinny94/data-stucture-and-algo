class PermutationsOfAString {
    
    public static void permutation(String s) {
        permutation("", s);
    }    

    public static void permutation(String current, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(current);
        } else {
            for (int i=0; i<n; i++) {
                permutation(current + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
            }
        }
    }

    public static void main(String[] args) {
        PermutationsOfAString obj = new PermutationsOfAString();
        obj.permutation("hello");
    }
}