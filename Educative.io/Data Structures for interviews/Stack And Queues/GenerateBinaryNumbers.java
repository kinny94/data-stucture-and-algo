class GenerateBinaryNumbers {

    //1.Start with Enqueuing 1.
    //2.Dequeue a number from queue and append 0 to it and enqueue it back to queue.
    //3.Perform step 2 but with appending 1 to the origional number and enqueue back to queue.
    //Queue takes integer values so before enqueueing it make sure to convert String to integer.
    //Size of Queue should be 1 more than number because for a single number we're enqueing two
    
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<Integer> queue = new Queue<Integer>(number + 1);
        queue.enqueue(1);

        for (int i=0; i<number; i++) {
            result[i] = String.valueOf(queue.dequeue());
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(Integer.parseInt(s1));
            queue.enquene(Integer.parseInt(s2));
        }

        return result;
    }
}