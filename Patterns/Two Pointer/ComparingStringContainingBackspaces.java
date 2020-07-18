class ComparingStringContainingBackspaces {
    public boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while (index1 >=0 || index2 >= 0) {
            int i1 = getNextValidCharacter(str1, index1);
            int i2 = getNextValidCharacter(str2, index2);

            System.out.println(i1 + " : " + i2);

            if (i1 < 0 && i2 < 0) {
                return true;
            }

            if (i1 < 0 || i2 < 0) {
                return false;
            }

            if (str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            }

            index1 = i1 - 1;
            index2 = i2 - 1;
        }

        return true;
    }    

    private int getNextValidCharacter(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }
            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        ComparingStringContainingBackspaces obj = new ComparingStringContainingBackspaces();
        System.out.println(obj.compare("xy#z", "xzz#"));
        System.out.println(obj.compare("xy#z", "xyz#"));
        System.out.println(obj.compare("xp#", "xyz##"));    
        System.out.println(obj.compare("xywrrmp", "xywrrmu#p"));
    }
}