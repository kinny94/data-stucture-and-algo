class CourseScheduler {

    public boolean canFinish(int numCourse, int[][] prerequistes) {

        int[] visisted = new int[numCourse];
        int count = 0;

        for (int i=0; i<prerequistes.length; i++) {
            visisted[prerequistes[i][0]]++;
        }

        Stack<Integer> stack = new Stack();

        for (int i=0; i<visisted.length; i++) {
            if (visisted[i] == 0 ) {
                stack.push(i);
            }
        }

        while( !stack.isEmpty()) {
            int curr = stack.pop();
            count++;

            for (int i=0; i<prerequistes.length; i++) {
                if (prerequistes[i][1] == curr) {
                    visisted[prerequistes[i][0]]--;
                    if (visisted[prerequistes[i][0]] == 0) {
                        stack.push(prerequistes[i][0]);
                    }
                }
            }
        }

        return count == numCourse;
    }
}