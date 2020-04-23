import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        
        while(!begin.isEmpty() && !end.isEmpty()) {

            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for(String s : begin) {

                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                String tempString = s;
                for(int i = 0; i < 4; i ++) {
                    char c = tempString.charAt(i);
                    String s1 = tempString.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + tempString.substring(i + 1);
                    String s2 = tempString.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + tempString.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        OpenTheLock obj = new OpenTheLock();
        System.out.println(obj.openLock(deadends, target));
    }
}