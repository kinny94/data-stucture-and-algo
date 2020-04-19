class StringCompression {
    public String compressedString(String s) {

        StringBuilder sb = new StringBuilder();

        int currentCount = 1;
        for (int i=0; i<s.length(); i++) {

            if (i == s.length() - 1) {
                sb.append(Character.toString(s.charAt(i)));
                sb.append(Integer.toString(currentCount));
                break; 
            }
            
            if (s.charAt(i) == s.charAt(i+1)) {
                currentCount++;
            } else {
                sb.append(Character.toString(s.charAt(i)));
                sb.append(Integer.toString(currentCount));
                currentCount = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        System.out.println(sc.compressedString("aabcccccaaa"));
    }
}