class Permutations {
    
   public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Queue<List<Integer>> permutations = new LinkedList<>();
       permutations.add(new ArrayList<>());
       
       for (int currentNumber: nums) {
           int n = permutations.size();
           for (int i=0; i<n; i++) {
               List<Integer> oldPermutations = permutations.poll();
               for (int j=0; j<=oldPermutations.size(); j++) {
                   List<Integer> newPermutation = new ArrayList<>(oldPermutations);
                   newPermutation.add(j, currentNumber);
                   if (newPermutation.size() == nums.length) {
                       result.add(newPermutation);
                   } else {
                       permutations.add(newPermutation);
                   }
               }
           }
       }   

       return result;
   }
}