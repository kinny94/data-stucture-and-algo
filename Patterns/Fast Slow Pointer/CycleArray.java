class CycleArray {
    public static boolean loopExists(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean isforward = arr[i] > 0;
            int slow = i;
            int fast = i;

            do {
                slow = findNextIndex(arr, isforward, slow);
                fast = findNextIndex(arr, isforward, fast);

                if (fast != -1) {
                    fast = findNextIndex(arr, isforward, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }

        return false;
    }    

    public static int findNextIndex(int[] arr, boolean isforward, int currentIndex) {
       
        boolean direction = arr[currentIndex] >= 0;

        if (isforward != direction) {
            return -1;
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if (nextIndex < 0) {
            nextIndex += arr.length;
        }

        if (nextIndex == currentIndex) {
            nextIndex = -1;
        }

        return nextIndex;
    }
    
    public static void main(String[] args) {
        System.out.println(CycleArray.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CycleArray.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CycleArray.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}