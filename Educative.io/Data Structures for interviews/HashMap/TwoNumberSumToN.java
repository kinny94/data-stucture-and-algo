class CheckSum 
{   
  public static int[] findSum(int[] arr, int n) 
  {
    int[] result = new int[2];
    Set<Integer> set = new HashSet<Integer>();
    for(int i: arr) 
    {
      if(set.contains(n - i)){
          result[0] = i;
          result[1] = n - i;
          break;
      }
      set.add(i);
    }
    return result;  
  }
};