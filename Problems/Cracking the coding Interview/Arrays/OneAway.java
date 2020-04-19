import java.util.*;

class OneAway {

    public boolean oneAway(String s1,  String s2) {
        if (s1.length() == s2.length()) {
            return replacement(s1, s2);
        } else if (s1.length() + 1 ==  s2.length()) {
            return insertion(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return removal(s1, s2);
        } else {
            return false;
        }
    }

    private boolean removal(String s1, String s2) {
        int[] arr = new int[128];

        for (int i=0; i<s1.length(); i++) {
            arr[s1.charAt(i)]++;
        }

        for (int i=0; i<s2.length(); i++) {
            arr[s2.charAt(i)]--;
        }

        int count = 0;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i]  == 1) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;

    }

    private boolean insertion(String s1, String s2) {

        int[] arr = new int[128];

        for (int i=0; i<s1.length(); i++) {
            arr[s1.charAt(i)]++;
        }

        for (int i=0; i<s2.length(); i++) {
            arr[s2.charAt(i)]--;
        }

        int count = 0;

        for (int i=0; i<arr.length; i++) {

            if (arr[i]  == -1) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;

    }

    private boolean replacement(String s1, String s2) {

        int[] arr = new int[128];

        for (int i=0; i<s1.length(); i++) {
            arr[s1.charAt(i)]++;
        }

        for (int i=0; i<s2.length(); i++) {
            arr[s2.charAt(i)]--;
        }

        int count = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        OneAway obj = new OneAway();
        System.out.println(obj.oneAway("pale", "ple"));
        System.out.println(obj.oneAway("pales", "pale"));
        System.out.println(obj.oneAway("pale", "bale"));
        System.out.println(obj.oneAway("pale", "bake"));
    }
}