class KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack();
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        stack.push(0);
        while (!stack.isEmpty()) {
            int key = stack.pop();
            for (int newKey : rooms.get(key)) {
                if (!seen[newKey]) {
                    seen[newKey] = true;
                    stack.push(newKey);
                }
            }
        }
        
        for (boolean room: seen) {
            if (room == false) return false;
        }
        return true;
    }
}