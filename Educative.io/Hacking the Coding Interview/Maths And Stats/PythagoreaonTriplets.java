class PythagoreanTriplets{  
    static List<int[]> findPythagoreanTriplets(int[] arr) {
        int n = arr.length;
        List<int[]> triplets = new ArrayList<int[]>();
        Arrays.sort(arr);
        
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) continue;
            
            int c2 = arr[i] * arr[i];
            
            int j = 0;
            int k = n - 1;
            
            while (j < k) {
                if (j == i || arr[j] == 0) {
                    j += 1;
                    continue;
                }
                
                if (k == i || arr[k] == 0) {
                    k -= 1;
                    continue;
                }
                
                int a2 = arr[j] * arr[j];
                int b2 = arr[k] * arr[k];
                
                if (a2 + b2 == c2) {
                    triplets.add(
                    new int[]{arr[j], arr[k], arr[i]});
                    break;
                }
                else if (a2 + b2 + (-c2) > 0) {
                    k -= 1;
                }
                else {
                    j += 1;
                }
            }
        }
        return triplets;
    }
    public static void main(String[] argv) {
        int[] l1 = {4,16,1,2,3,5,6,8,25,10};
        
        List<int[]> t1 = findPythagoreanTriplets(l1);
        
        System.out.println("Original: " + Arrays.toString(l1));
        String result = "";
        
        for (int[] a : t1) {
            result += "[";
            for (int x : a) {
                result += Integer.toString(x) + ",";
            }
            result = result.replaceAll(",$", "");
            result += "]";
        }
        System.out.println("Pythagorean triplets: " + result); 
    } 
    
}