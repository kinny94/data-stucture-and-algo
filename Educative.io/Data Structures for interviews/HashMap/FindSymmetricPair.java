//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();  
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();  
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSymmetric {

    public static String findSymmetric(int[][] arr) 
    {
          //Create an empty Hash Map
          //Traverse given Array
          //Look for second element of each pair in the hash. i.e for pair (1,2) look for key 2 in map.
          //If found then store it in the result array, otherwise insert the pair in hash
          HashMap < Integer,Integer > hashMap = new HashMap < Integer,Integer >();
  
          String result = "";
              
          //Traverse through the given array
          for (int i = 0; i < arr.length; i++) 
      {
              int first = arr[i][0];
              int second = arr[i][1];
  
              Integer value = hashMap.get(second);
  
              if (value != null && value == first) 
        {
                  //Symmetric Pair found
                  result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
              }
              else 
          hashMap.put(first, second);
          }
          return result;
      }
  
  }