import java.util.HashMap;
import java.util.Map;

class FruitsInBasket {
    public int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                if (map.get(arr[windowStart]) == 0) {
                    map.remove(arr[windowStart]);
                } 
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }


        return maxLength;
    }    

    public static void main(String[] args) {
        FruitsInBasket obj = new FruitsInBasket();
        System.out.println("Maximum number of fruits: " + obj.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + obj.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}