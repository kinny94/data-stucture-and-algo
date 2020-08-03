class LetterCasePermutation {
    public List<String> letterCasePermutation(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }
        
        permutations.add(str);
        
        for (int i=0; i<str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                
                for (int j=0; j<n; j++) {
                    char[] ch = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(ch[i])) {
                        ch[i] = Character.toLowerCase(ch[i]);
                    } else {
                        ch[i] = Character.toUpperCase(ch[i]);
                    }
                    
                    permutations.add(String.valueOf(ch));
                }
            }
        }
        
        return permutations;
    }
}