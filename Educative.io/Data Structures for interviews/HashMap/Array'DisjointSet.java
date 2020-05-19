class CheckDisjoint {

    public static Object isDisjoint(int[] arr1,int[] arr2) {
  
      HashSet<Integer> set = new HashSet<>();
  
      for (int i=0; i<arr1.length; i++) {
        set.add(arr1[i]);
      }
  
      for (int i=0; i<arr2.length; i++) {
        if (set.contains(arr2[i])) {
          return false;
        }
      }
      // Write - Your - Code    
      return true;    
    } 
  }