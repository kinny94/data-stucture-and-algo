class SubArryaSumEqualToK {
    public int subarraySum(int[] arr, int k) {
        int count=0,cs=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            cs+=arr[i];
            if(cs==k)
                count++;
            if(hm.containsKey(cs-k))
                count+=hm.get(cs-k);
            
            if(!hm.containsKey(cs))
	                hm.put(cs, 1);
	        else
	                hm.put(cs, hm.get(cs)+1);
        }     
        return count;
    }
}