import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbreviatedWord {
    StringBuilder str;
    int start;
    int count;

    AbbreviatedWord(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

class GeneralizedAbbrevation {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        int wordLen = word.length();
        List<String> result = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));

        while (!queue.isEmpty()) {
            AbbreviatedWord abWord = queue.poll();
            if (abWord.start == wordLen) {
                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }

                result.add(abWord.str.toString());
            } else {
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str), abWord.start + 1, abWord.count + 1));

                if (abWord.count != 0) {
                    abWord.str.append(abWord.count);
                }

                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)), abWord.start + 1, 0));
            }
        }

        return result;
    }

    // backtracking method
    public static List<String> generateAbbreviations(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);
    
        return ret;
    }
    
    private static void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbrevation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbrevation.generateAbbreviations("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
