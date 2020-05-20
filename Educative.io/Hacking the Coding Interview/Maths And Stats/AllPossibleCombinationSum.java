class SumCombinations{
    static String print(ArrayList<ArrayList<Integer>> arr) {
        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            result += "[";
            for (int j = 0; j < arr.get(i).size(); j++) {
                result += Integer.toString(arr.get(i).get(j)) + ",";
            }
            result = result.replaceAll(",$", "");
            result += "]";
        }   
        return result;
    }
    
    
    static void printAllSumRec(int target, int currentSum,int start,
    ArrayList<ArrayList<Integer>> output, ArrayList<Integer> result) {
        
        if (target == currentSum) {
            output.add((ArrayList)result.clone());
        }
        
        for (int i = start; i < target; ++i) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                
                result.add(i);
                printAllSumRec(target, tempSum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }
    static ArrayList<ArrayList<Integer>> printAllSum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        printAllSumRec(target, 0, 1, output, result);
        return output;
    }
    
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = printAllSum(n);
        System.out.println("All sum combinations of " + n );
        System.out.println(print(result));
    }
}  