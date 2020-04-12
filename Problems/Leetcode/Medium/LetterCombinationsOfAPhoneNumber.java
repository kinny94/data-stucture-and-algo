import java.util.*;

class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        int len = digits.length();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");map.put('5', "jkl");map.put('8', "tuv");
        map.put('3', "def");map.put('6', "mno");map.put('9', "wxyz");
        map.put('4', "ghi");map.put('7', "pqrs");
        
        String[] arr = new String[digits.length()];
        int index = 0;
        for(char ch:digits.toCharArray()){
            arr[index] = map.get(ch);
            index++;
        }
        System.out.println(Arrays.toString(arr));
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        permute(res, sb, 0, arr);
        return res;
    }
    
  
    
    void permute(List<String> res, StringBuilder output, int startPos, String[] arr){
        if(output.length() == arr.length) res.add(new String(output));
        if(startPos < arr.length){
           for(int j=0;j<arr[startPos].length();j++){
                output.append(arr[startPos].charAt(j));
                permute(res, output, startPos+1, arr);
                output.deleteCharAt(output.length()-1);
            } 
        } 
    }

    public static void main(String[] args) {
        String numbr = "23";
        LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
        System.out.println(lc.letterCombinations(numbr));

    }
}