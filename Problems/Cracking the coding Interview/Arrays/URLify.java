import java.util.*;

class URLify {

    private String urlify(String str, int trueLength) {
        char[] url = str.toCharArray();
        int spaceCount = 0;
        
        for (int i=0; i<trueLength; i++) {
            if (url[i] == ' ') {
                spaceCount++;
            }
        }

        int index = str.length() - 1;

        if (trueLength < url.length) {
            url[trueLength] = '\0';
        }

        for (int i=trueLength-1; i >=0; i--) {
            if (url[i] == ' ') {
                url[index - 1] = '0';
                url[index - 2] = '2';
                url[index - 3] = '%';
                index = index - 3;
            } else {
                url[index - 1] = url[i];
                index--;
            }
        }

        return Arrays.toString(url);
    }

    public static void main(String[] args) {
        URLify obj = new URLify();
        System.out.println(obj.urlify("Mr John Smith     ", 13));
    }
}